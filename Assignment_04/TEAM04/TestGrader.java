import java.io.FileNotFoundException;

/**
 * @author Karandeep Singh Grewal - kgrewal2
 */
public class TestGrader {
    public static void main(String[] args) throws FileNotFoundException {
        StudentRepository41 studentRepo = new StudentRepository41();

        StudentCoreData42 studentCoreData421 = new StudentCoreData42("john");
        studentRepo.addStudent(studentCoreData421);

        StudentCoreData42 studentCoreData422 = new StudentCoreData42("abraham");
        studentRepo.addStudent(studentCoreData422);

        StudentCoreData42 studentCoreData423 = new StudentCoreData42("george");
        studentRepo.addStudent(studentCoreData423);

        StudentCoreData42 studentCoreData424 = new StudentCoreData42("nick");
        studentRepo.addStudent(studentCoreData424);

        Grader43 grader = new Grader43();
        String filepath = "grades.csv";
        grader.loadFile(filepath);
        System.out.println("GRADES FILE: " + filepath);
        int unknownStudents = grader.loadDataToStudentRepository(studentRepo);
        System.out.println("Total Unknown Students: " + unknownStudents);
    }
}