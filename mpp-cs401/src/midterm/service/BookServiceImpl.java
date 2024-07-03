package midterm.service;

import midterm.data.DataAccess;
import midterm.data.DataAccessFacade;
import midterm.entity.Book;

import java.util.HashMap;
import java.util.Optional;

public class BookServiceImpl implements BookService {

    @Override
    public Optional<Book> searchBookByIsbn(String isbn) {
        DataAccess da = new DataAccessFacade();
        HashMap<String, Book> bookMap = da.readBooksMap();

        if (bookMap.containsKey(isbn)) {
            return Optional.of(bookMap.get(isbn));
        }
        return Optional.empty();
    }

    @Override
    public Book saveNewBookCopy(Book book) {
        DataAccess da = new DataAccessFacade();
        book.addCopy();
        da.updateNewBook(book);
        return book;
    }
}
