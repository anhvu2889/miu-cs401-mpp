package lab3.prob3A;

public class Circle extends Cylinder {
    private final double radius;

    public Circle(double radius) {
        super(radius, radius);
        this.radius = radius;
    }

    public double getRadius() {
        return this.radius;
    }

    public double computeArea() {
        return Math.PI * this.radius * this.radius;
    }
}
