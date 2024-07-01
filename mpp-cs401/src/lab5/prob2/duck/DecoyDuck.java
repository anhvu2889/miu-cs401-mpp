package lab5.prob2.duck;

import lab5.prob2.behavior.fly.CannotFly;
import lab5.prob2.behavior.quack.MuteQuack;

public class DecoyDuck extends Duck {
    public DecoyDuck() {
        this.flyBehavior = new CannotFly();
        this.quackBehavior = new MuteQuack();
    }

    @Override
    public void display() {
        System.out.println("Decoy Duck");
    }
}
