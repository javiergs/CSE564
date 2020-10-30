package src;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Reporter34 is the visitor implementation that takes care of reading the attendance file,
 * getting the an AttendanceStudent object and add it to the StudentDecorator.
 *
 * @author  Ashutosh
 * @version 1.0
 * @since   2019-10-25, number of hours = 2 hours
 */

public class Reporter34 implements Repository31Visitor {
    protected String attendanceFilePath;
    protected Map<String, Map<String, Integer>> attendanceData;
    protected int unknownAttendanceCount;

    public int getUnknownAttendanceCount() {
        return this.unknownAttendanceCount;
    }

    public Reporter34(String attendanceFileName) throws FileNotFoundException {
        this.attendanceData = new HashMap<>();
        this.attendanceFilePath = attendanceFileName;
        this.loadAttendance();
        this.unknownAttendanceCount = 0;
    }

    @Override
    public void visitStudent(Decorator32 student) {
        String studentID = student.getAsurite();
        if (attendanceData.containsKey(studentID)) {
            Decorator32 attendanceStudent = Decorator32StudentFactory.makeAttendanceStudent(attendanceData.get(studentID));
            ((Decorator32StudentDecorator) student).addStudent(attendanceStudent);
            student = attendanceStudent;
        }
        else {
            this.unknownAttendanceCount++;
        }
    }

    public void loadAttendance() throws FileNotFoundException {
        Scanner readFile = new Scanner(new File(this.attendanceFilePath));
        String date = "";
        boolean firstLine = true;

        if (readFile.hasNextLine()){
            String[] row = readFile.nextLine().split(",");
            date = row[1];
        }
        while (readFile.hasNextLine()){
            String line = readFile.nextLine();
            if(!line.trim().isEmpty()) {
                if(!firstLine) {
                    Map<String, Integer> data = new HashMap<>();
                    String[] row = line.split(",");
                    String id = row[0].split("@")[0];
                    data.put(date, Integer.parseInt(row[1]));
                    attendanceData.put(id, data);
                }
            }
            firstLine = false;
        }
    }

}
