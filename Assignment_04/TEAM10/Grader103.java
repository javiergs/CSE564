/**
 * Grader103 reads students' grades from a given CSV file, and sets the grades for each Repository101Student.
 * Time taken to implement ~ 3 hours.
 *
 * @author Sai Pramod Vallabhaneni
 * @version 1.0
 * @since 10-24-2020
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Grader103 {

    private static Grader103 uniqueGrader = null;
    private String filepath;

    protected Grader103() {
    }

    public static Grader103 getInstance() {
        if (uniqueGrader == null) {
            uniqueGrader = new Grader103();
        }
        return uniqueGrader;
    }
    
    
    public void setFilePath(String filePath) {
        filepath = filePath;
    }

    public void processGrades(Repository101StudentRepository studentRepository) throws FileNotFoundException {
        if (filepath == null) {
            throw new IllegalArgumentException("Missing FilePath for input grades file");
        }

        Scanner sc = new Scanner(new File(uniqueGrader.filepath));
        sc.useDelimiter(",");
        String[] splitString;
        List<String> columnNames = new ArrayList<>();
        HashMap<String, String[]> scoresMap = new HashMap<>();

        boolean firstRow = true;
        while (sc.hasNextLine()) {
            String studentRow = sc.nextLine();
            splitString = studentRow.split(",");
            if (splitString.length == 0) {
                continue;
            }
            if (firstRow) {
                firstRow = false;
                columnNames.addAll(Arrays.asList(splitString));
            } else {
                scoresMap.put(splitString[0], splitString);
            }
        }
        sc.close();

        String[] studentScoresRow;

        for (Repository101Iterator iter = studentRepository.getIterator(); iter.hasNext(); ) {
            Decorator102Student student = (Decorator102Student) iter.peek();
            if (scoresMap.containsKey(student.getAsurite())) {
                studentScoresRow = scoresMap.get(student.getAsurite());
                Decorator102Student gradesCard = new Decorator102StudentGrade();

                for (int i = 1; i < studentScoresRow.length; i++) {
                    ((Decorator102StudentGrade) gradesCard).add(student);
                    ((Decorator102StudentGrade) gradesCard).addStudentGrade(columnNames.get(i), Integer.parseInt(studentScoresRow[i]), 100);
                }
                iter.setNext(gradesCard);
            }
        }
        studentRepository.notifyTable();
        
    }
    
}

