package lab7.prob4;

public interface Squeakable extends Quackable {
    default void quack() {
        System.out.println("Squeaking");
    }
}
