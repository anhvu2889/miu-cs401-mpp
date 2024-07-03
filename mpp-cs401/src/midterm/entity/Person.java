package midterm.entity;

import java.io.Serial;
import java.io.Serializable;

public class Person implements Serializable {
    @Serial
    private static final long serialVersionUID = 3665880920647848288L;
    private final String firstName;
    private final String lastName;
    private final String telephone;
    private final Address address;

    public Person(String firstName, String lastName, String telephone, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephone = telephone;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTelephone() {
        return telephone;
    }

    public Address getAddress() {
        return address;
    }
}
