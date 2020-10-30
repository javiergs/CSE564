import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Class to decorate student object with GradeDecorator and add grades for
 * assignments that are uploaded from a csv file.
 * 
 * I worked for 1 hr on this task.
 *
 * @author Raghavan
 * @version 1.0
 */

public class Grader93 {
    /**
     * Given the path to grades file, adds grade decorator to students in
     * repository.
     * 
     * @param filePath
     * @return no. of students not graded
     */
    public int gradeStudents(String filePath) {
        BufferedReader br = null;
        String nextLine = null;
        List<String> columns = new ArrayList<>();
        Map<String, String> gradeMap = new HashMap<>();
        try {
            br = new BufferedReader(new FileReader(filePath));
            if ((nextLine = br.readLine()) != null) {
                String[] colNames = nextLine.split(",");
                for (String colName : colNames)
                    columns.add(colName);
            }
            while ((nextLine = br.readLine()) != null) {
                String[] parts = nextLine.split(",", 2);
                if (parts.length > 1)
                    gradeMap.put(parts[0], parts[1]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Student91Observable studentRepo = Student91Observable.getInstance();
        int unknown = 0;
        List<Grade92Decorator> newGradeList = new ArrayList<>();

        for (Iterator<?> iter = studentRepo.getIterator(); iter.hasNext();) {
            Student92Model student = (Student92CoreData) iter.next();
            Grade92Decorator gStudent = new Grade92Decorator(student);
            String gradeCard = gradeMap.get(student.getStudentAsurite());
            if (gradeCard != null) {
                List<Grade92Model> gradesList = new ArrayList<>();
                String[] grades = gradeCard.split(",");
                for (int i = 0; i < grades.length; i++) {
                    Grade92Model grade = new Grade92Model(columns.get(i + 1), grades[i], "100");
                    gradesList.add(grade);
                }
                gStudent.add(gradesList);
                newGradeList.add(gStudent);
            } else
                unknown++;
        }
        for (Grade92Decorator grade : newGradeList) {
            studentRepo.add(grade);
        }
        return unknown;
    }

}
