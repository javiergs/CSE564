/**
 * @author Karandeep Singh Grewal - kgrewal2
 */
public class StudentGrades42 {
    StudentCoreData42 studentCoreData42;
    private String quizName;
    private int weightage;
    private int grade;

    public StudentGrades42(StudentCoreData42 studentCoreData42) {
        this.studentCoreData42 = studentCoreData42;
    }

    public void add(String quizName, int weightage, int grade) {
        this.quizName = quizName;
        this.weightage = weightage;
        this.grade = grade;
    }
}
