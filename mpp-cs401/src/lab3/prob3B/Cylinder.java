package lab3.prob3B;

public class Cylinder {
    private final Circle circle;
    private final double height;

    public Cylinder(double radius, double height) {
        this.circle = new Circle(radius);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    protected double getRadius() {
        return circle.getRadius();
    }

    public double computeVolume() {
        return circle.computeArea() * height;
    }
}
