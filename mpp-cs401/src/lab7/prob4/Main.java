package lab7.prob4;

class Main {

    public static void main(String[] args) {
        Duck[] ducks =
                {new MallardDuck(), new DecoyDuck(), new RedheadDuck(), new RubberDuck()};
        for (Duck duck : ducks) {
            duck.display();
            duck.fly();
            duck.quack();
            duck.swim();
        }

    }

}
