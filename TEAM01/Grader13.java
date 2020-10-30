package team1.nagarjun;

import team1.gaurav.Repository11;
import team1.gaurav.Repository11Iterator;
import team1.sukhpreet.Decorator12Grades;
import team1.sukhpreet.Decorator12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Grader13 {

    private Repository11 repository;

    public Grader13(Repository11 repository) {
        this.repository = repository;
    }

    public int loadGrades(String filename) {
        int unknownStudents = 0;
        Map<String, List<String>> studentGrades = new HashMap<>();
        List<String> headers = new ArrayList<>();

        String csvLine;
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            while ((csvLine = br.readLine()) != null) {
                String[] split = csvLine.split(",");
                if (csvLine.length() < 1 || split.length < 1) {
                    continue;
                }
                if (csvLine.startsWith("SIS Login ID")) {
                    headers.addAll(Arrays.asList(csvLine.split(",")));
                } else {
                    String[] gradesOfAStudent = csvLine.split(",");
                    List<String> grades = new ArrayList<>();
                    for (int i = 1; i < gradesOfAStudent.length; i++) {
                        grades.add(gradesOfAStudent[i]);
                    }
                    studentGrades.put(gradesOfAStudent[0], grades);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        Repository11Iterator itr = repository.getIterator();
        while (itr.hasNext()) {
            Decorator12 student = itr.next();
            List<String> currentStudentGrades = studentGrades.get(student.getAsurite());
            if (currentStudentGrades == null) {
                unknownStudents++;
            } else {
                for (int i = 0; i < currentStudentGrades.size(); i++) {
                    Decorator12Grades gradeCard = new Decorator12Grades(headers.get(i + 1), Float.parseFloat(currentStudentGrades.get(i)), 100);
                    gradeCard.add(student);
                    student = gradeCard;
                }
                repository.updateStudent(student.getAsurite(), student);
            }
        }
        return unknownStudents;
    }

}
