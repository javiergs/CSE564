import java.io.FileNotFoundException;
import java.util.Iterator;


/**
 * @author Karandeep Singh Grewal - kgrewal2
 */
public class Grader43 {
    private final int CSV_ASURITE_INDEX = 0;
    private CSVBuffer43Reusable csvBuffer;

    public void loadFile(String filepath) throws FileNotFoundException {
        csvBuffer = new CSVBuffer43Reusable();
        csvBuffer.loadFile(filepath);
    }

    /**
     * @return Number of students for which no grade details were found.
     */
    public int loadDataToStudentRepository(StudentRepository41 studentRepository) {
        int unknownStudents = 0;
        Iterator iter = studentRepository.getIterator();
        while (iter.hasNext()) {
            StudentCoreData42 student = (StudentCoreData42) iter.next();
            boolean isGradeAdded = addGradeDetailsToStudent(student);
            if (!isGradeAdded) {
                unknownStudents++;
            }
        }
        return unknownStudents;
    }


    /**
     * @return false if no records were found for the given student
     */
    private boolean addGradeDetailsToStudent(StudentCoreData42 student) {
        String asurite = student.getAsurite();
        for (String[] gradeDetails : csvBuffer.data) {
            String asuriteToBeChecked = gradeDetails[CSV_ASURITE_INDEX].replace(" ", "");
            if (asurite.equalsIgnoreCase(asuriteToBeChecked)) {
                for (int i = 1; i < csvBuffer.totalColumns; i++) {
                    String quizName = csvBuffer.headerArray[i];
                    String grade = gradeDetails[i];
                    StudentGrades42 studentGrades = new StudentGrades42(student);
                    grade = grade.replaceAll(" ","");
                    if (grade.equals("")) {
                        grade = "0";
                    }
                    studentGrades.add(quizName, Integer.parseInt(grade), 5);
                }
                System.out.println("GRADES ADDED FOR " + asurite);
                return true;
            }
        }
        System.out.println("<<<< NO RECORD FOUND FOR " + asurite + " >>>>");
        return false;
    }
}