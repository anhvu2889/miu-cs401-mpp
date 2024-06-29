package lab4.probC;

public class Hourly extends Employee {
    private final double hourlyWage;
    private final double hoursPerWeek;

    public Hourly(double hourlyWage, double hoursPerWeek) {
        this.hourlyWage = hourlyWage;
        this.hoursPerWeek = hoursPerWeek;
    }

    @Override
    public double calcGrossPay(int month, int year) {
        return hourlyWage * hoursPerWeek * 4;
    }
}
