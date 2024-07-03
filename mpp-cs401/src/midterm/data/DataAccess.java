package midterm.data;

import midterm.entity.Book;
import midterm.entity.BookCopy;
import midterm.entity.CheckoutRecord;
import midterm.entity.LibraryMember;

import java.util.HashMap;

public interface DataAccess {

    public HashMap<String, User> readUserMap();

    public HashMap<String, Book> readBooksMap();

    public HashMap<String, LibraryMember> readMemberMap();

    public void updateNewBook(Book book);

    public LibraryMember searchMember(String memberId);

    public Book searchBook(String isbn);

    public void saveBook(Book book);

    public HashMap<String, CheckoutRecord> readCheckoutRecordMap();

    public void saveNewMember(LibraryMember member);

    public HashMap<String, CheckoutRecord> saveNewCheckoutRecord(CheckoutRecord checkoutRecordHashMap, int copyNum);

    public void updateBookCopyAvailability(String isbn, BookCopy checkoutBookCopy);
}
