package lab2.prob2A;

public class Student {
    private final String name;
    private final GradeReport gradeReport;

    public Student(String name) {
        this.name = name;
        this.gradeReport = new GradeReport(this);
    }
}
