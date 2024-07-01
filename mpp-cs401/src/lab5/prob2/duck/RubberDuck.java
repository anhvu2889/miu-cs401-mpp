package lab5.prob2.duck;

import lab5.prob2.behavior.fly.CannotFly;
import lab5.prob2.behavior.quack.Quack;
import lab5.prob2.behavior.quack.Squeak;

public class RubberDuck extends Duck {
    public RubberDuck() {
        this.flyBehavior = new CannotFly();
        this.quackBehavior = new Squeak();
    }
    @Override
    public void display() {
        System.out.println("Rubber Duck");
    }
}
