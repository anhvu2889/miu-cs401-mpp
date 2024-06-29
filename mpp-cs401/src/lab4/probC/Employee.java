package lab4.probC;

public abstract class Employee {

    private String empId;

    public void print() {
        System.out.println(STR."""
                Employee
                Id: \{empId}
                """);
    }

    public PayCheck calcCompensation(int month, int year) {
        double grossPay = calcGrossPay(month, year);
        return new PayCheck(grossPay,
                grossPay * 0.23,
                grossPay * 0.05,
                grossPay * 0.01,
                grossPay * 0.03,
                grossPay * 0.075);
    }

    public abstract double calcGrossPay(int month, int year);
}
