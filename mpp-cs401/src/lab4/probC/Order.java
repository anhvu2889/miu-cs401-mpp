package lab4.probC;

import java.time.LocalDate;

public class Order {
    private String orderNo;
    private LocalDate orderDate;
    private double orderAmount;

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public double getOrderAmount() {
        return orderAmount;
    }
}
