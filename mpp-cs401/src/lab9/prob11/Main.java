package lab9.prob11;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Employee> emps = Arrays.asList(new Employee("Joe", "Davis", 120000),
                new Employee("John", "Sims", 110000),
                new Employee("Joe", "Stevens", 200000),
                new Employee("Andrew", "Reardon", 80000),
                new Employee("Joe", "Cummings", 760000),
                new Employee("Steven", "Walters", 135000),
                new Employee("Thomas", "Blake", 111000),
                new Employee("Alice", "Richards", 101000),
                new Employee("Donald", "Trump", 100000));


        System.out.println(
                emps.stream()
                        .filter(emp -> emp.getSalary() > 100000)
                        .filter(emp -> emp.getLastName().charAt(0) > 'M' && emp.getLastName().charAt(0) <= 'Z')
                        .map(emp -> STR."\{emp.getFirstName()} \{emp.getLastName()}")
                        .sorted()
                        .collect(Collectors.joining(", ")));


    }


}
