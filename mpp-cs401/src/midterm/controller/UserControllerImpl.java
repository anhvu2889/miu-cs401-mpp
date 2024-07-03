package midterm.controller;


import midterm.data.Auth;
import midterm.data.DataAccess;
import midterm.data.DataAccessFacade;
import midterm.data.User;
import midterm.entity.*;
import midterm.exception.LibrarySystemException;
import midterm.exception.LoginException;

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

    public void login(String id, String password) throws LoginException {
        if (id.isEmpty() || password.isEmpty()) {
            throw new LoginException("ID or Password must not empty");
        }
        HashMap<String, User> map = dataAccess.readUserMap();
        if (!map.containsKey(id)) {
            throw new LoginException("ID " + id + " not found");
        }
        String passwordFound = map.get(id).getPassword();
        if (!passwordFound.equals(password)) {
            throw new LoginException("Password incorrect");
        }
        currentAuth = map.get(id).getAuthorization();

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

        BookCopy checkoutBookCopy = checkAvailableBookCopy(bookMap, isbn);

        LibraryMember libraryMember = memberMap.get(memberId);
        LocalDateTime dateTime = LocalDateTime.now();
        LocalDate checkoutDate = LocalDate.now();
        LocalDate dueDate = checkoutDate.plusDays(bookMap.get(isbn).getMaxCheckoutLength());

        CheckoutRecordEntry checkoutRecordEntry = new CheckoutRecordEntry(checkoutDate, dueDate, checkoutBookCopy);
        CheckoutRecord checkoutRecord = new CheckoutRecord(libraryMember, checkoutRecordEntry, dateTime);
        da.updateBookCopyAvailability(isbn, checkoutBookCopy);

        HashMap<String, CheckoutRecord> checkoutRecordHashMap = da.saveNewCheckoutRecord(checkoutRecord,
                checkoutBookCopy.getCopyNum());

        return checkoutRecordHashMap.values().stream().toList();
    }

    private BookCopy checkAvailableBookCopy(HashMap<String, Book> bookMap, String isbn) throws LibrarySystemException {
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
        LibraryMember libraryMember = dataAccess.searchMember(memberId);
        if (libraryMember != null) {
            throw new LibrarySystemException("Member already exist");
        }

        if (firstName.trim().isEmpty() || lastName.trim().isEmpty() || memberId.trim().isEmpty() || telephone.trim().isEmpty()
                || street.trim().isEmpty() || city.trim().isEmpty() || state.trim().isEmpty() || zip.trim().isEmpty()) {
            throw new LibrarySystemException("All fields must be non-empty!");
        }

        String zipcodeRegex = "^\\d{5}";
        if (!zip.matches(zipcodeRegex)) {
            throw new LibrarySystemException("ZipCode is illegal");
        }
        String telephoneRegex = "^\\d{3}-\\d{3}-\\d{4}$";
        if (!telephone.matches(telephoneRegex)) {
            throw new LibrarySystemException("telephone number input is illegal");
        }
        String mIDRegexString = "^\\d{4}";
        if (!memberId.matches(mIDRegexString)) {
            throw new LibrarySystemException("Member ID should be four digits");
        }

        char[] chs = memberId.toCharArray();
        for (char ch : chs) {
            if (ch < '0' || ch > '9') {
                throw new LibrarySystemException("Member Id must be numeric");
            }
        }

        Address address = new Address(street, city, state, zip);
        LibraryMember member = new LibraryMember(memberId, firstName, lastName, telephone, address);
        dataAccess.saveNewMember(member);

    }
}
