package team1.aditya;

import team1.gaurav.Repository11;
import team1.gaurav.Repository11Iterator;
import team1.sukhpreet.Decorator12Attendance;
import team1.sukhpreet.Decorator12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Reporter14 class, for loading the attendance csv file & adding the attendance values to the respective student
 *
 * @author Aditya Bajaj
 * @version 1.0
 * @since 10-26-2020
 */

public class Reporter14 {

    private Repository11 repository;

    public Reporter14(Repository11 repository) {
        this.repository = repository;
    }

    public int loadAttendance(String filename) {
        int unknownStudents = 0;
        Map<String, List<String>> studentAttendance = new HashMap<>();
        List<String> headers = new ArrayList<>();

        String csvLine;
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            while ((csvLine = br.readLine()) != null) {
                if (csvLine.length() < 1) {
                    continue;
                }
                if (csvLine.contains("User Email")) {
                    headers.addAll(Arrays.asList(csvLine.split(",")));
                } else {
                    List<String> attendance = new ArrayList<>();
                    String[] values = csvLine.split(",");
                    for (int i = 1; i < values.length; i++) {
                        attendance.add(values[i]);
                    }
                    String[] id = values[0].split("@");
                    studentAttendance.put(id[0], attendance);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        Repository11Iterator itr = repository.getIterator();
        while (itr.hasNext()) {
            Decorator12 student = itr.next();
            List<String> currentStudentAttendance = studentAttendance.get(student.getAsurite());

            if (currentStudentAttendance == null) {
                unknownStudents++;
            } else {
                Decorator12Attendance attendanceCard;
                for (int i = 0; i < currentStudentAttendance.size(); i++) {
                    attendanceCard = new Decorator12Attendance(headers.get(i+1), Float.parseFloat(currentStudentAttendance.get(i)));
                    attendanceCard.add(student);
                    student = attendanceCard;
                }
                repository.updateStudent(student.getAsurite(), student);
            }
        }
        return unknownStudents;
    }
}