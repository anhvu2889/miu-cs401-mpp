package lab7.prob4;

public interface Flyable {
    default void fly() {
        System.out.println("Flying");
    }
}
