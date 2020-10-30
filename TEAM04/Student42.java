
import java.util.ArrayList;

public interface Student42 {
    void add(String date, int minutes);
    void add(String assignmentName, int marksObtained, int weightage);

    void setAttendanceList(ArrayList<AttendanceModel42> attendanceList);
    void setGradesList(ArrayList<GradesModel42> gradesList);
    ArrayList<AttendanceModel42> getAttendanceList();
    ArrayList<GradesModel42> getGradesList();
}
