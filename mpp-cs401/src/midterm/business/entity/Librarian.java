package midterm.business.entity;

import java.io.Serial;
import java.io.Serializable;

public class Librarian extends Person implements Serializable {
    @Serial
    private static final long serialVersionUID = 7314671064532273757L;

    public Librarian(String firstName, String lastName, String telephone, Address address) {
        super(firstName, lastName, telephone, address);
    }
}
