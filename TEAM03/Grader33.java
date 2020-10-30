package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


/**
 * This class is responsible for loading grades.
 *
 * @author Akash Devdhar
 * 
 * Number of Hours taken : 1
 */

public class Grader33 implements Repository31Visitor {
    protected String gradesFilePath;
    protected Map<String, Map<String, Double>> gradeData;
    protected int unknownGrades;

    public Grader33(String filePath) throws IOException {
        this.unknownGrades = 0;
        this.gradesFilePath = filePath;
        this.gradeData = new HashMap<>();
        this.loadGrades();
    }

    public int getUnknownGrades() {
        return unknownGrades;
    }

    /**
     * @param student the student who's grades are being loaded is visited
     * @return
     */
    public void visitStudent(Decorator32 student) {
        String studentID = student.getAsurite();
        if (gradeData.containsKey(studentID)) {
            Decorator32 gradesStudent =
                    Decorator32StudentFactory.makeGradesStudent(gradeData.get(studentID));
            ((Decorator32StudentDecorator) student).addStudent(gradesStudent);
        }
        else {
            this.unknownGrades += 1;
        }
    }


    /**
     *  This method is responsible for loading the grades from the grades file.
     */
    public void loadGrades() throws IOException {
        BufferedReader reader = null;
        String line;
        String[] headers = {};

        File gradesFile = new File(this.gradesFilePath);
        reader = new BufferedReader(new FileReader(gradesFile));
        if ((line = reader.readLine()) != null) {
            headers = line.split(",");
        }

        reader.readLine();

        while ((line = reader.readLine()) != null) {
            Map<String, Double> data = new HashMap<>();
            String[] grades = line.split(",");
            String asurite = grades[0].split("@")[0];

            for (int i = 1; i < headers.length; i++) {
                data.put(headers[i], Double.parseDouble(grades[i]));
                gradeData.put(asurite, data);
            }
        }

    }
}


