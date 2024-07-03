package midterm.controller;

import midterm.data.DataAccess;
import midterm.data.DataAccessFacade;
import midterm.entity.Book;
import midterm.exception.LibrarySystemException;
import midterm.service.BookService;
import midterm.service.BookServiceImpl;
import midterm.utils.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookControllerImpl implements BookController {
    @Override
    public List<String> getAllBookIds() {
        DataAccess da = new DataAccessFacade();
        List<String> retval = new ArrayList<>();
        retval.addAll(da.readBooksMap().keySet());
        return retval;
    }

    @Override
    public Book addNewBookCopy(String isbn) throws LibrarySystemException {
        if (Util.isEmpty(isbn)) {
            throw new LibrarySystemException("ISBN must be not empty");
        }

        BookService bookService = new BookServiceImpl();
        Optional<Book> bookOpt = bookService.searchBookByIsbn(isbn);
        if (bookOpt.isEmpty()) {
            throw new LibrarySystemException("Book not found, please enter correct ISBN");
        }

        return bookService.saveNewBookCopy(bookOpt.get());
    }
}
