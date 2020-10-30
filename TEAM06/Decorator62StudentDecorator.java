import java.util.List;

/**
 * Student Decorator Base implementation. This Class needs to be extended to
 * decorate student attributes (attendance and grades). It is also a composition
 * of Decorator62StudentInterface.
 * 
 * @author Akhilesh Krishnan (akrish84)
 * @since 10/25/2020
 * 
 */
public class Decorator62StudentDecorator implements Decorator62StudentInterface {

	Decorator62StudentInterface student;

	Decorator62StudentDecorator(Decorator62StudentInterface student) {
		this.student = student;
	}

	@Override
	public long getId() {
		return student.getId();
	}

	@Override
	public void setId(long id) {
		student.setId(id);
	}

	@Override
	public String getFirstName() {
		return student.getFirstName();
	}

	@Override
	public void setFirstName(String firstName) {
		student.setFirstName(firstName);
	}

	@Override
	public String getLastName() {
		return student.getLastName();
	}

	@Override
	public void setLastName(String lastName) {
		student.setLastName(lastName);
	}

	@Override
	public String getProgramAndPlan() {
		return student.getProgramAndPlan();
	}

	@Override
	public void setProgramAndPlan(String programAndPlan) {
		student.setProgramAndPlan(programAndPlan);
	}

	@Override
	public String getAcademicLevel() {
		return student.getAcademicLevel();
	}

	@Override
	public void setAcademicLevel(String academicLevel) {
		student.setAcademicLevel(academicLevel);
	}

	@Override
	public String getAsurite() {
		return student.getAsurite();
	}

	@Override
	public void setAsurite(String asurite) {
		student.setAsurite(asurite);
	}

	@Override
	public void addGrade(Decorator62GradeBean grade) {
		student.addGrade(grade);
	}

	@Override
	public List<Decorator62GradeBean> getGrades() {
		return student.getGrades();
	}

	@Override
	public void addAttendance(Decorator62AttendanceBean attendance) {
		student.addAttendance(attendance);
	}

	@Override
	public List<Decorator62AttendanceBean> getAllAttendance() {
		return student.getAllAttendance();

	}

}
