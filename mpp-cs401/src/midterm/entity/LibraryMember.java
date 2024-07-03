package midterm.entity;

import java.io.Serial;
import java.io.Serializable;

final public class LibraryMember extends Person implements Serializable {

    @Serial
    private static final long serialVersionUID = -2226197306790714013L;

    private final String memberId;

    private CheckoutRecord checkoutRecord;

    public LibraryMember(String memberId, String firstName, String lastName, String telephone, Address address) {
        super(firstName, lastName, telephone, address);
        this.memberId = memberId;
    }

    public String getMemberId() {
        return memberId;
    }

    public CheckoutRecord getCheckoutRecord() {
        return checkoutRecord;
    }

    @Override
    public String toString() {
        return "Member Info: " + "ID: " + memberId + ", name: " + getFirstName() + " " + getLastName() +
                ", " + getTelephone() + " " + getAddress();
    }

}