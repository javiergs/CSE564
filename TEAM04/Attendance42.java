import java.util.ArrayList;

public class Attendance42 extends StudentDecorator42 {

    public Attendance42(Student42 decoratedStudent42) {
        super(decoratedStudent42);
    }

    @Override
    public void add(String date, int minutes) {
        ArrayList<AttendanceModel42> attendanceList = super.decoratedStudent42.getAttendanceList();
        if (attendanceList != null) {
            for (AttendanceModel42 attendance : attendanceList) {
                if (attendance.getDate().equalsIgnoreCase(date)) {
                    attendance.setMinutes(minutes);
                    return;
                }
            }
        }

        AttendanceModel42 attendance = new AttendanceModel42();
        attendance.setDate(date);
        attendance.setMinutes(minutes);

        if(attendanceList == null) {
            ArrayList<AttendanceModel42> attendanceArrayList = new ArrayList<>();
            attendanceArrayList.add(attendance);
            super.decoratedStudent42.setAttendanceList(attendanceArrayList);
        } else {
            attendanceList.add(attendance);
            super.decoratedStudent42.setAttendanceList(attendanceList);
       }
    }

    @Override
    public void setAttendanceList(ArrayList<AttendanceModel42> attendanceList) {
        super.decoratedStudent42.setAttendanceList(attendanceList);
    }

    @Override
    public void setGradesList(ArrayList<GradesModel42> gradesList) {
        super.decoratedStudent42.setGradesList(gradesList);
    }

    @Override
    public ArrayList<AttendanceModel42> getAttendanceList() {
        return super.decoratedStudent42.getAttendanceList();
    }

    @Override
    public ArrayList<GradesModel42> getGradesList() {
        return super.decoratedStudent42.getGradesList();
    }
}
