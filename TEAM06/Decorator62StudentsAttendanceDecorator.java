import java.util.ArrayList;
import java.util.List;

/**
 * It decorates a Decorator62StudentInterface with attendance.
 * Provides Setters and Getters to access student's attendance.
 * 
 * @author Akhilesh Krishnan (akrish84)
 * @since 10/25/2020
 *
 */
public class Decorator62StudentsAttendanceDecorator extends Decorator62StudentDecorator {

	List<Decorator62AttendanceBean> attendanceList;

	Decorator62StudentsAttendanceDecorator(Decorator62StudentInterface student) {
		super(student);
		attendanceList = new ArrayList<>();
	}

	@Override
	public void addAttendance(Decorator62AttendanceBean attendance) {
		attendanceList.add(attendance);
	}

	@Override
	public List<Decorator62AttendanceBean> getAllAttendance() {
		return attendanceList;

	}

}
