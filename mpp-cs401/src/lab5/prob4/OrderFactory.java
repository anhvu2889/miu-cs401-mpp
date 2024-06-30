package lab5.prob4;

import java.time.LocalDate;

class OrderFactory {
    public static Order newOrder(Customer customer, LocalDate date) {
        if (customer == null) throw new NullPointerException("Null customer");
        Order ord = new Order(date);
        customer.addOrder(ord);
        return ord;
    }
}
