package lab4.probC;

import java.time.LocalDate;
import java.util.List;

public class Commissioned extends Employee {
    private final double commission;
    private final double baseSalary;
    private final List<Order> orders;

    public Commissioned(double commission, double baseSalary, List<Order> orders) {
        this.commission = commission;
        this.baseSalary = baseSalary;
        this.orders = orders;
    }

    @Override
    public double calcGrossPay(int month, int year) {
        double orderAmountofLastMonth = 0;
        LocalDate previousMonth = LocalDate.of(month, year, 1).minusMonths(1);
        for (Order order : orders) {
            if (order.getOrderDate() != null &&
                    order.getOrderDate().getYear() == previousMonth.getYear() &&
                    order.getOrderDate().getMonth().getValue() == previousMonth.getMonth().getValue()) {
                orderAmountofLastMonth += order.getOrderAmount();
            }
        }
        return baseSalary + orderAmountofLastMonth * commission;
    }


}
