package midterm.controller;

import midterm.entity.CheckoutRecord;
import midterm.exception.LibrarySystemException;
import midterm.exception.LoginException;

import java.util.List;

public interface UserController {

    void login(String id, String password) throws LoginException;

    List<String> getAllMemberIds();

    List<CheckoutRecord> getAllCheckoutRecords();

    List<CheckoutRecord> loadCheckoutForm(String memberId, String isbn) throws Exception;

    void addNewLibraryMember(String firstName, String lastName, String memberId, String telephone, String street, String city,
                             String state,
                             String zip) throws LibrarySystemException;
}
