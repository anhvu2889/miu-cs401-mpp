package lab5.prob3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(3);
        Rectangle rectangle = new Rectangle(4, 5);
        Triangle triangle = new Triangle(4, 5);
        List<Shape> shapes = new ArrayList<Shape>(Arrays.asList(circle, rectangle, triangle));
        double sumArea = 0;
        for (Shape shape : shapes) {
            sumArea += shape.computeArea();
        }
        System.out.printf("Sum of Areas = %.2f \n", sumArea);
    }
}
