package lab5.prob4;

import java.time.LocalDate;

class Main {
    public static void main(String[] args) {
        Customer cust = new Customer("Bob");
        Order order = Order.newOrder(cust, LocalDate.now());
        order.addItem("Shirt");
        order.addItem("Laptop");

        order = Order.newOrder(cust, LocalDate.now());
        order.addItem("Pants");
        order.addItem("Knife set");

        System.out.println(cust.getOrders());
    }
}

		
