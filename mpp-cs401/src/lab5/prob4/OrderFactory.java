package lab5.prob4;

import java.time.LocalDate;

class OrderFactory {
    public static Order createNewOrder(Customer customer, LocalDate date) {
        if (customer == null)
            throw new NullPointerException("Null customer");
        Order newOrder = new Order(date);
        customer.addOrder(newOrder);
        return newOrder;
    }

    public static void addItem(Order order, String itemName) {
        order.addItem(new Item(itemName));
    }
}
