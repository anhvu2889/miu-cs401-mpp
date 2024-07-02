package midterm.dataaccess;

import midterm.business.entity.Book;
import midterm.business.entity.LibraryMember;

import java.util.HashMap;

public interface DataAccess {
    public HashMap<String, Book> readBooksMap();

    public HashMap<String, User> readUserMap();

    public HashMap<String, LibraryMember> readMemberMap();

    public void saveNewMember(LibraryMember member);
}
