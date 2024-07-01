package lab5.prob2.duck;

import lab5.prob2.behavior.fly.FlyWithWings;
import lab5.prob2.behavior.quack.Quack;

public class MallardDuck extends Duck {
    public MallardDuck() {
        this.flyBehavior = new FlyWithWings();
        this.quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("Mallard Duck");
    }
}
