package lab3.prob4;

public abstract class Property {
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public abstract double computeRent();
}
