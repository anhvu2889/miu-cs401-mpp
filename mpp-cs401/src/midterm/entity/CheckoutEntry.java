package midterm.entity;

import java.time.LocalDate;

public class CheckoutEntry {
    private final BookCopy bookCopy;
    private final LocalDate checkoutDate;
    private final LocalDate dueDate;

    public CheckoutEntry(BookCopy bookCopy, LocalDate checkoutDate, LocalDate dueDate) {
        this.bookCopy = bookCopy;
        this.checkoutDate = checkoutDate;
        this.dueDate = dueDate;
    }
}
