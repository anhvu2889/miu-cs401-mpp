package midterm.exception;

import java.io.Serial;
import java.io.Serializable;

public class LoginException extends Exception implements Serializable {

    @Serial
    private static final long serialVersionUID = 8978723266036027364L;

    public LoginException() {
        super();
    }

    public LoginException(String msg) {
        super(msg);
    }

    public LoginException(Throwable t) {
        super(t);
    }


}
