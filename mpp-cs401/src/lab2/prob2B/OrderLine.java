package lab2.prob2B;

public class OrderLine {
    private final Order order;
    private final String productCode;
    private final int quantity;
    private final double price;

    public OrderLine(Order order, String productCode, int quantity, double price) {
        this.order = order;
        this.productCode = productCode;
        this.quantity = quantity;
        this.price = price;
    }

}
