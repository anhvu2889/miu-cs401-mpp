package midterm.service;

import midterm.data.DataAccess;
import midterm.data.DataAccessFacade;
import midterm.entity.Address;
import midterm.entity.LibraryMember;
import midterm.exception.LibrarySystemException;

public class UserServiceImpl implements UserService {

    private final DataAccess dataAccess = new DataAccessFacade();

    @Override
    public void checkExistingUserById(String memberId) throws LibrarySystemException {
        LibraryMember libraryMember = dataAccess.searchMember(memberId);
        if (libraryMember != null) {
            throw new LibrarySystemException("Member already exist");
        }
    }

    @Override
    public void validateUserInput(String firstName, String lastName, String memberId, String telephone,
                                  String street, String city, String state, String zip) throws LibrarySystemException {
        if (firstName.trim().isEmpty() || lastName.trim().isEmpty() || memberId.trim().isEmpty() || telephone.trim().isEmpty()
                || street.trim().isEmpty() || city.trim().isEmpty() || state.trim().isEmpty() || zip.trim().isEmpty()) {
            throw new LibrarySystemException("All fields must be non-empty!");
        }
        String mIDRegexString = "^\\d{4}";
        if (!memberId.matches(mIDRegexString)) {
            throw new LibrarySystemException("Member ID should be four digits");
        }

        char[] chs = memberId.toCharArray();
        for (char ch : chs) {
            if (ch < '0' || ch > '9') {
                throw new LibrarySystemException("Member Id must be numeric");
            }
        }
        String zipcodeRegex = "^\\d{5}";
        if (!zip.matches(zipcodeRegex)) {
            throw new LibrarySystemException("ZipCode is illegal");
        }
        String telephoneRegex = "^\\d{3}-\\d{3}-\\d{4}$";
        if (!telephone.matches(telephoneRegex)) {
            throw new LibrarySystemException("telephone number input is illegal");
        }
    }

    @Override
    public void saveNewLibraryMember(String firstName, String lastName, String memberId, String telephone, String street, String city, String state, String zip) {
        Address address = new Address(street, city, state, zip);
        LibraryMember member = new LibraryMember(memberId, firstName, lastName, telephone, address);
        dataAccess.saveNewMember(member);
    }
}
