package lab5.prob4;

import java.time.LocalDate;

class Main {
    public static void main(String[] args) {
        Customer newCustomer = CustomerFactory.createNewCustomer("Bob");
        Order newOrder = OrderFactory.createNewOrder(newCustomer, LocalDate.now());
        OrderFactory.addItem(newOrder, "Shirt");
        OrderFactory.addItem(newOrder, "Laptop");

        newOrder = OrderFactory.createNewOrder(newCustomer, LocalDate.now());
        OrderFactory.addItem(newOrder, "Pants");
        OrderFactory.addItem(newOrder, "Knife set");

        System.out.println(newCustomer.getOrders());
    }
}

		
