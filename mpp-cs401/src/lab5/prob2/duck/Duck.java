package lab5.prob2.duck;

import lab5.prob2.behavior.fly.FlyBehavior;
import lab5.prob2.behavior.quack.QuackBehavior;

public abstract class Duck {
    protected FlyBehavior flyBehavior;
    protected QuackBehavior quackBehavior;

    public abstract void display();

    public void fly() {
        flyBehavior.fly();
    }

    public void quack() {
        quackBehavior.quack();
    }
}
