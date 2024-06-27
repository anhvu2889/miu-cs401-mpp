package lab3.prob4;

public class House implements Property {
    private Address address;
    private final double lotSize;

    public House(Address address, double lotSize) {
        this.address = address;
        this.lotSize = lotSize;
    }

    public House(double lotSize) {
        this.lotSize = lotSize;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public double computeRent() {
        return 0.1 * lotSize;
    }
}
