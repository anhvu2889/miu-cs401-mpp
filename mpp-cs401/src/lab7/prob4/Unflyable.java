package lab7.prob4;

public interface Unflyable extends Flyable {
    default void fly() {
        System.out.println("Cannot fly");
    }
}
