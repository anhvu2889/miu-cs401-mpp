package midterm.service;


import midterm.entity.Book;
import midterm.entity.BookCopy;
import midterm.exception.LibrarySystemException;

import java.util.HashMap;
import java.util.Optional;

public interface BookService {

    Optional<Book> searchBookByIsbn(String isbn);

    Book saveNewBookCopy(Book book);

    BookCopy checkAvailableBookCopy(HashMap<String, Book> bookMap, String isbn) throws LibrarySystemException;
}
