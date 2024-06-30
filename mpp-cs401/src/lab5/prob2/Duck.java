package lab5.prob2;

public abstract class Duck implements Flyable, Quackable {
    public abstract void display();

    public void swim(){
        System.out.println("Swimming");
    }

    @Override
    public void fly() {
        System.out.println("Flying with wings");
    }

    @Override
    public void quack() {
        System.out.println("Quack by squeaking");
    }
}
