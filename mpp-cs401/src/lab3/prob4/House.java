package lab3.prob4;

public class House extends Property {
    private final double lotSize;

    public House(double lotSize) {
        this.lotSize = lotSize;
    }

    @Override
    public double computeRent() {
        return 0.1 * lotSize;
    }
}
