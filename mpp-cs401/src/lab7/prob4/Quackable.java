package lab7.prob4;

public interface Quackable {
    default void quack() {
        System.out.println("Quacking");
    }
}
