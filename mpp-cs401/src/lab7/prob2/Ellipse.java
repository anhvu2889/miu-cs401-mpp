package lab7.prob2;

public class Ellipse implements ClosedCurve {
    private final double semiMajorAxis;
    private final double ellipticIntegralAtEccentricity;

    public Ellipse(double sma, double eie) {
        semiMajorAxis = sma;
        ellipticIntegralAtEccentricity = eie;
    }

    @Override
    public double computePerimeter() {
        return 4 * semiMajorAxis * ellipticIntegralAtEccentricity;
    }

}
