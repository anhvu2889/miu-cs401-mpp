package lab3.prob3A;

public class Cylinder {
    private final double radius;
    private final double height;

    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    protected double getRadius() {
        return radius;
    }

    public double computeVolume() {
        return Math.PI * radius * radius * height;
    }
}
