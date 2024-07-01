package lab5.prob2;

import lab5.prob2.duck.*;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Duck> ducks = new ArrayList<>();
        ducks.add(new MallardDuck());
        ducks.add(new RubberDuck());
        ducks.add(new DecoyDuck());
        ducks.add(new RedheadDuck());
        for (Duck duck : ducks) {
            duck.display();
            duck.quack();
            duck.fly();
            System.out.println("------------");
        }
    }
}
