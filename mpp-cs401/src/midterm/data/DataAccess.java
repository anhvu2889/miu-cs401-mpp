package midterm.data;

import midterm.entity.Book;
import midterm.entity.LibraryMember;

import java.util.HashMap;

public interface DataAccess {
    public HashMap<String, Book> readBooksMap();

    public HashMap<String, User> readUserMap();

    public HashMap<String, LibraryMember> readMemberMap();

    public void saveNewMember(LibraryMember member);
}
