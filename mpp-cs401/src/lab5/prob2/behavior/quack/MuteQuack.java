package lab5.prob2.behavior.quack;

public class MuteQuack implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("Cannot Quack");
    }
}
