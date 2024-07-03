package midterm.service;

import midterm.data.DataAccess;
import midterm.data.DataAccessFacade;
import midterm.entity.Book;
import midterm.entity.BookCopy;
import midterm.exception.LibrarySystemException;

import java.util.HashMap;
import java.util.Optional;

public class BookServiceImpl implements BookService {

    @Override
    public Optional<Book> searchBookByIsbn(String isbn) {
        DataAccess dataAccess = new DataAccessFacade();
        HashMap<String, Book> bookMap = dataAccess.readBooksMap();

        if (bookMap.containsKey(isbn)) {
            return Optional.of(bookMap.get(isbn));
        }
        return Optional.empty();
    }

    @Override
    public Book saveNewBookCopy(Book book) {
        DataAccess dataAccess = new DataAccessFacade();
        book.addCopy();
        dataAccess.updateNewBook(book);
        return book;
    }

    @Override
    public BookCopy checkAvailableBookCopy(HashMap<String, Book> bookMap, String isbn) throws LibrarySystemException {
        BookCopy[] bookCopies = bookMap.get(isbn).getCopies();
        for (BookCopy bookCopy : bookCopies) {
            if (bookCopy.getAvailableBookCopies()) {
                return bookCopy;
            }
        }
        throw new LibrarySystemException("This book is out of copies");
    }
}
