package midterm.controller;

import midterm.entity.Book;
import midterm.exception.LibrarySystemException;

import java.util.List;

public interface BookController {
    List<String> getAllBookIds();

    Book addNewBookCopy(String isbn) throws LibrarySystemException;
}
