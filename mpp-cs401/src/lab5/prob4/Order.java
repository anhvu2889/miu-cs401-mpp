package lab5.prob4;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


class Order {
    private final LocalDate orderDate;
    private final List<Item> items;

    //use a factory method
    public Order(LocalDate orderDate) {
        this.orderDate = orderDate;
        items = new ArrayList<Item>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    @Override
    public String toString() {
        return STR."\{orderDate}: \{items.toString()}";
    }
}
