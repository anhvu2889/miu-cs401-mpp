package midterm.entity;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

public class CheckoutRecordEntry implements Serializable {
    @Serial
    private static final long serialVersionUID = 6550573558639754705L;

    private final LocalDate checkOutDate;
    private final LocalDate dueDate;
    private final BookCopy bookCopy;

    public CheckoutRecordEntry(LocalDate checkOutDate, LocalDate dueDate, BookCopy bookCopy) {
        this.checkOutDate = checkOutDate;
        this.dueDate = dueDate;
        this.bookCopy = bookCopy;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public BookCopy getBookNum() {
        return bookCopy;
    }
}
