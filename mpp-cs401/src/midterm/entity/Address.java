package midterm.entity;

import java.io.Serializable;

/* Immutable */
final public class Address implements Serializable {

    private static final long serialVersionUID = -891229800414574888L;
    private final String street;
    private final String city;
    private final String state;
    private final String zip;

    public Address(String street, String city, String state, String zip) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    @Override
    public String toString() {
        return "(" + street + ", " + city + ", " + zip + ")";

    }
}
