package lab2.prob2B;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final String number;
    private final List<OrderLine> orderLines;

    public Order(String number, List<OrderLine> orderLines) {
        this.number = number;
        this.orderLines = orderLines;
    }

    public Order(String number) {
        this.number = number;
        this.orderLines = new ArrayList<>();
    }

    public void addLine(OrderLine orderLine) {
        orderLines.add(orderLine);
    }

}
