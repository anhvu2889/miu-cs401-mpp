package midterm.service;

import midterm.data.Auth;
import midterm.data.User;
import midterm.exception.LibrarySystemException;
import midterm.exception.LoginException;

import java.util.HashMap;

public interface UserService {
    void checkExistingUserById(String memberId) throws LibrarySystemException;

    void validateUserInput(String firstName, String lastName, String memberId, String telephone, String street, String city,
                           String state,
                           String zip) throws LibrarySystemException;

    void saveNewLibraryMember(String firstName, String lastName, String memberId, String telephone, String street, String city,
                              String state,
                              String zip);

    void validateLoginInput(String id, String password) throws LoginException;
    void authentication(HashMap<String, User> map, String id, String password) throws LoginException;
    Auth authorization(HashMap<String, User> map, String id);

}
