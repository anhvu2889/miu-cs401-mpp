package lab5.prob2.duck;

import lab5.prob2.behavior.fly.FlyWithWings;
import lab5.prob2.behavior.quack.Squeak;

public class RedheadDuck extends Duck {
    public RedheadDuck() {
        this.flyBehavior = new FlyWithWings();
        this.quackBehavior = new Squeak();
    }

    @Override
    public void display() {
        System.out.println("Red head duck");
    }
}
