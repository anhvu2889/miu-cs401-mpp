package lab3.prob3B;

public class Circle {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return this.radius;
    }

    public double computeArea() {
        return Math.PI * this.radius * this.radius;
    }
}
