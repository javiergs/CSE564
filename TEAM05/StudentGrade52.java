import java.util.ArrayList;
import java.util.List;

//author :- Sakshi Jain
public class StudentGrade52 extends StudentDecorator52{
    private List<Grade53> studentGrades = new ArrayList<>();

    @Override
    public List<Grade53> getGrades() {
        return studentGrades;
    }

	@Override
	public List<Attendance54> getAttendance() {
		return  this.studentEntity.getAttendance();
	}
	
	public void addGrade(Grade53 grade) {
		studentGrades.add(grade);
	}

}
