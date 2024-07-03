package midterm.controller;


import midterm.data.Auth;
import midterm.data.DataAccess;
import midterm.data.DataAccessFacade;
import midterm.data.User;
import midterm.entity.*;
import midterm.exception.LibrarySystemException;
import midterm.exception.LoginException;
import midterm.service.UserService;
import midterm.service.UserServiceImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class UserControllerImpl implements UserController {
    public static Auth currentAuth = null;

    private final DataAccess dataAccess = new DataAccessFacade();
    private final UserService userService = new UserServiceImpl();

    public void login(String id, String password) throws LoginException {
        userService.validateLoginInput(id, password);

        HashMap<String, User> map = dataAccess.readUserMap();
        userService.authentication(map, id, password);

        currentAuth = userService.authorization(map, id);

    }

    @Override
    public List<String> getAllMemberIds() {
        DataAccess da = new DataAccessFacade();
        List<String> retval = new ArrayList<>(da.readMemberMap().keySet());
        return retval;
    }


    @Override
    public List<CheckoutRecord> loadCheckoutForm(String memberId, String isbn) throws Exception {
        HashMap<String, LibraryMember> memberMap = dataAccess.readMemberMap();
        HashMap<String, Book> bookMap = dataAccess.readBooksMap();
        if (!memberMap.containsKey(memberId)) {
            throw new LibrarySystemException(STR."Member id with \{memberId} is not found");
        }
        if (!bookMap.containsKey(isbn) || bookMap.get(isbn).getCopies() == null) {
            throw new LibrarySystemException("This book is not available");
        }

        BookCopy checkoutBookCopy = getAvailableBookCopy(bookMap, isbn);

        LibraryMember libraryMember = memberMap.get(memberId);
        LocalDateTime dateTime = LocalDateTime.now();
        LocalDate checkoutDate = LocalDate.now();
        LocalDate dueDate = checkoutDate.plusDays(bookMap.get(isbn).getMaxCheckoutLength());

        CheckoutRecordEntry checkoutRecordEntry = new CheckoutRecordEntry(checkoutDate, dueDate, checkoutBookCopy);
        CheckoutRecord checkoutRecord = new CheckoutRecord(libraryMember, checkoutRecordEntry, dateTime);
        dataAccess.updateBookCopyAvailability(isbn, checkoutBookCopy);

        HashMap<String, CheckoutRecord> checkoutRecordHashMap = dataAccess.saveNewCheckoutRecord(checkoutRecord,
                checkoutBookCopy.getCopyNum());

        return checkoutRecordHashMap.values().stream().toList();
    }

    private BookCopy getAvailableBookCopy(HashMap<String, Book> bookMap, String isbn) throws LibrarySystemException {
        BookCopy[] bookCopies = bookMap.get(isbn).getCopies();
        for (BookCopy bookCopy : bookCopies) {
            if (bookCopy.getAvailableBookCopies()) {
                return bookCopy;
            }
        }
        throw new LibrarySystemException("This book is out of copies");
    }

    @Override
    public List<CheckoutRecord> getAllCheckoutRecords() {
        HashMap<String, CheckoutRecord> checkoutRecordHashMap = dataAccess.readCheckoutRecordMap();
        if (checkoutRecordHashMap == null) {
            checkoutRecordHashMap = new HashMap<>();
        }
        return checkoutRecordHashMap.values().stream()
                .sorted(Comparator.comparing(CheckoutRecord::getDateTime))
                .collect(Collectors.toList());
    }

    public static String[][] allMembers() {
        DataAccess da = new DataAccessFacade();
        List<LibraryMember> libraryMembers = new ArrayList<>(da.readMemberMap().values());
        String[][] results = new String[libraryMembers.size()][5];
        int i = 0;
        for (LibraryMember lb : libraryMembers) {
            String[] value = new String[5];
            value[0] = (i + 1) + "";
            value[1] = lb.getMemberId();
            value[2] = lb.getFirstName();
            value[3] = lb.getLastName();
            value[4] = lb.getTelephone();
            results[i] = value;
            i++;
        }

        return results;
    }

    public static String[][] allBooks() {
        DataAccess da = new DataAccessFacade();
        List<Book> books = new ArrayList<>(da.readBooksMap().values());
        String[][] results = new String[books.size()][5];
        int i = 0;
        for (Book lb : books) {
            String[] value = new String[5];
            value[0] = (i + 1) + "";
            value[1] = lb.getIsbn();
            value[2] = lb.getTitle();
            StringBuilder authors = new StringBuilder();
            lb.getAuthors().forEach(e -> {
                authors.append(e.getFirstName()).append(" ").append(e.getLastName()).append(", ");
            });
            int bookCopy = 0;
            for (BookCopy e : lb.getCopies()) {
                if (e.getAvailableBookCopies()) bookCopy++;
            }
            value[3] = !authors.isEmpty() ? authors.substring(0, authors.length() - 2) : "";
            value[4] = String.valueOf(bookCopy);
            results[i] = value;
            i++;
        }

        return results;
    }

    @Override
    public void addNewLibraryMember(String firstName, String lastName, String memberId, String telephone, String street, String city,
                                    String state,
                                    String zip) throws LibrarySystemException {
        userService.validateUserInput(firstName, lastName, memberId, telephone, street, city, state, zip);
        userService.checkExistingUserById(memberId);
        userService.saveNewLibraryMember(firstName, lastName, memberId, telephone, street, city, state, zip);
    }
}
