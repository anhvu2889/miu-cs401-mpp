package lab5.prob4;

class CustomerFactory {
    public static Customer createNewCustomer(String name) {
        return new Customer(name);
    }
}
