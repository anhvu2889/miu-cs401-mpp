package lab2.prob2A;

public class GradeReport {
    private final Student student;
    private String grade;

    public GradeReport(Student student) {
        this.student = student;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
