package lab3.prob1;

public class PersonWithJob {
    private final Person person;
    private final double salary;

    public double getSalary() {
        return salary;
    }

    public Person getPerson() {
        return person;
    }

    PersonWithJob(String name, double s) {
        person = new Person(name);
        salary = s;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof PersonWithJob personWithJob)) return false;
        return this.person.equals(personWithJob.getPerson()) &&
                this.getSalary() == personWithJob.getSalary();
    }

    public static void main(String[] args) {
        PersonWithJob personWithJob1 = new PersonWithJob("Joe", 30000);
        PersonWithJob personWithJob2 = new PersonWithJob("Joe", 30000);
        Person person = new Person("Joe");
        System.out.println("personWithJob1.equals(personWithJob2)? " + personWithJob1.equals(personWithJob2));
        System.out.println("personWithJob1.equals(person)? " + personWithJob1.equals(person));
        System.out.println("person.equals(personWithJob1)? " + person.equals(personWithJob1));
    }


}
