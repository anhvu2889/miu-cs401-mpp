package lab7.prob2;

public class EquilateralTriangle implements Polygon {
    private final double side;

    public EquilateralTriangle(double side) {
        this.side = side;
    }

    public double[] getLengths() {
        return new double[]{side, side, side};
    }
}
