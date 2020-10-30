import java.util.ArrayList;
import java.util.List;

//author :- Sakshi Jain
public class StudentAttendance52 extends StudentDecorator52 {

    private List<Attendance54> studentAttendance = new ArrayList<>();

	@Override
	public List<Attendance54> getAttendance() {
		return studentAttendance;
	}

	@Override
	public List<Grade53> getGrades() {
		return this.studentEntity.getGrades();
	}
	
	public void addAttendance(Attendance54 attendance) {
		this.studentAttendance.add(attendance);
	}
}
