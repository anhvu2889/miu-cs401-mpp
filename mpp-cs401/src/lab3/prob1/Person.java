package lab3.prob1;


public class Person {

    private final String name;

    Person(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Person person)) return false;
        return this.name.equals(person.name);
    }

    public static void main(String[] args) {

    }

}
