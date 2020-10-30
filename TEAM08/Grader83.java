/**
 * <h1>Grader83</h1>
 * The Grader83 class is the helper class to add grade
 * decorations to students from a grade csv file.
 * <p>
 * CSE564 - Assignment 4
 * Team 8 - Member 3 (ID 83)
 * Completion time: 5 hours
 *
 * @author Kaysi Pilcher (kcacheso)
 * @since 10-26-2020
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Grader83 {

    private Repository81StudentRepository studentRepository;

    public Grader83(Repository81StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public int loadGrades(String filepath) throws FileNotFoundException {
        int unknownStudents = 0;
        Scanner scan = new Scanner(new File(filepath));
        String labelLine = scan.nextLine();
        String[] labels = labelLine.split(",");
        while(scan.hasNext()) {
            String line = scan.nextLine();
            String[] studentDetails = line.split(",");
            boolean successful = parseStudentDetails(labels, studentDetails);
            if (!successful) unknownStudents += 1;
        }
        return unknownStudents;
    }

    private boolean parseStudentDetails(String[] labels, String[] studentDetails) {
        boolean result = false;
        if (studentDetails.length > 0) {
            Decorator82StudentInterface currentStudent = getStudent(studentDetails[0]);
            if (currentStudent != null) {
                ArrayList grades = new ArrayList();
                for(int i = 1; i < studentDetails.length; i++) {
                    grades.add(new Grader83Grade(labels[i], Double.parseDouble(studentDetails[i])));
                }
                currentStudent = new Decorator82StudentGrades(currentStudent);
                currentStudent.add(grades);
                studentRepository.replaceStudent(currentStudent, studentDetails[0]);
                result = true;
            }
        }
        return result;
    }

    private Decorator82StudentInterface getStudent(String asurite) {
        Repository81Iterator iter = studentRepository.getIterator();
        while (iter.hasNext()) {
            Decorator82StudentInterface student = (Decorator82StudentInterface) iter.next();
            if (student.getAsurite().equals(asurite)) {
                return student;
            }
        }
        return null;
    }

}
