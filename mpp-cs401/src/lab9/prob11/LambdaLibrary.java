package lab9.prob11;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaLibrary {
    public static final TriFunction<List<Employee>, Integer, Character, String> lambda = (listEmployees, minSalary, minChar) ->
            listEmployees.stream()
                    .filter(emp -> emp.getSalary() > minSalary)
                    .filter(emp -> emp.getLastName().charAt(0) > minChar)
                    .map(emp -> STR."\{emp.getFirstName()} \{emp.getLastName()}")
                    .sorted()
                    .collect(Collectors.joining(", "));

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

        System.out.println(lambda.apply(emps, 100000, 'M'));
    }
}
