package midterm.service;


import midterm.entity.Book;

import java.util.Optional;

public interface BookService {

    Optional<Book> searchBookByIsbn(String isbn);

    Book saveNewBookCopy(Book book);
}
