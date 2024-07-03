package midterm.entity;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CheckoutRecord implements Serializable {
    @Serial
    private static final long serialVersionUID = -728095373785964854L;
    private final LibraryMember libraryMember;
    private final List<CheckoutRecordEntry> checkoutRecordEntryList = new ArrayList<>();
    private final LocalDateTime dateTime;

    public CheckoutRecord(LibraryMember libraryMember, CheckoutRecordEntry RecordEntry, LocalDateTime dateTime) {
        this.libraryMember = libraryMember;
        this.checkoutRecordEntryList.add(RecordEntry);
        this.dateTime = dateTime;
    }

    public LibraryMember getLibraryMember() {
        return libraryMember;
    }

    public List<CheckoutRecordEntry> getCheckoutRecordEntryList() {
        return checkoutRecordEntryList;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

}
