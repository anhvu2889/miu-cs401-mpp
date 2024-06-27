package lab3.prob4;

public class Condominium implements Property {
    private final int numFloors;
    private Address address;

    public Condominium(int numFloors, Address address) {
        this.numFloors = numFloors;
        this.address = address;
    }

    public Condominium(int numFloors) {
        this.numFloors = numFloors;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public double computeRent() {
        return 400 * numFloors;
    }
}
