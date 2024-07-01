package lab5.prob2.behavior.fly;

public class CannotFly implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("Cannot fly");
    }
}
