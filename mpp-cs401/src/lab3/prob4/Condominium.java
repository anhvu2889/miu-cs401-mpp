package lab3.prob4;

public class Condominium extends Property {
    private final int numFloors;

    public Condominium(int numFloors) {
        this.numFloors = numFloors;
    }

    @Override
    public double computeRent() {
        return 400 * numFloors;
    }
}
