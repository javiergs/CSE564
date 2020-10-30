import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * A class for decorating students with grades in the repository
 * @author Chandan Kiragadalu Javaregowda
 * @version 1.0
 * Time taken - 4 hours
 */
public class LoadGrades53 {
    StudentRepository51 repository;

    public LoadGrades53(StudentRepository51 repository){
        this.repository = repository;
    }

    /**
     * This method which will be called when LoadGrades button is pressed on UI
     * The students from repository are iterated and decorated with grades
     * @param filePath the path of the file where grades are stored
     * @throws FileNotFoundException
     */
    public void gradeStudents(String filePath) throws FileNotFoundException {
        BufferedReader br = null;
        String nextLine = null;
        List<String> headers = new ArrayList<>();
        Map<String, List<String>> gradeMap = new HashMap<>();
        try {
            br = new BufferedReader(new FileReader(filePath));
            if ((nextLine = br.readLine()) != null) {
                String[] colNames = nextLine.split(",");
                for(String colName : colNames)
                    headers.add(colName);
            }
            while((nextLine = br.readLine()) != null) {
                String[] parts = nextLine.split(",", 2);
                if (parts.length < 2) continue;
                String[] grades = parts[1].split(",");
                List<String> gradesList = new ArrayList<>();
                for(int i=0; i <grades.length; i++){
                    gradesList.add(grades[i]);
                }
                gradeMap.put(parts[0], gradesList);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Student52> students = new ArrayList<>();
        for(StudentIterator51 iter = repository.getIterator(); iter.hasNext();) {
            Student52 student = (Student52) iter.next();
            List<String> studentGrades = gradeMap.get(student.getAsurite());
            if(studentGrades != null) {
                StudentGrade52 studentGrade = new StudentGrade52();
                studentGrade.setStudent(student);
                for(int i = 0; i < studentGrades.size(); i++) {
                    Grade53 grade = new Grade53(headers.get(i + 1), studentGrades.get(i), "100");
                    studentGrade.addGrade(grade);
                }
                students.add(studentGrade);
            }
            else
            	students.add(student);
        }
        this.repository.updateRepository(students);
    }
}
