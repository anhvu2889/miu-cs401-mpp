package lab4.probC;

public class Salaried extends Employee {
    private final double salary;

    public Salaried(double salary) {
        this.salary = salary;
    }

    @Override
    public double calcGrossPay(int month, int year) {
        return salary;
    }
}
