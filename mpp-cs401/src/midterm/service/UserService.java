package midterm.service;

import midterm.exception.LibrarySystemException;

public interface UserService {
    void checkExistingUserById(String memberId) throws LibrarySystemException;

    void validateUserInput(String firstName, String lastName, String memberId, String telephone, String street, String city,
                           String state,
                           String zip) throws LibrarySystemException;

    void saveNewLibraryMember(String firstName, String lastName, String memberId, String telephone, String street, String city,
                              String state,
                              String zip);

}
