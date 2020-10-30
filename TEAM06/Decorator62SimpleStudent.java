import java.util.List;

/**
 * It is a simple implementation of Decorator62StudentInterface.
 * Has getters and setters for basic student attributes which does not include
 * grades and attendance.
 * 
 * @author Akhilesh Krishnan (akrish84)
 * @since 10/25/2020
 *
 */

public class Decorator62SimpleStudent implements Decorator62StudentInterface {

	private long id;
	private String firstName;
	private String lastName;
	private String programAndPlan;
	private String academicLevel;
	private String asurite;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getProgramAndPlan() {
		return programAndPlan;
	}

	public void setProgramAndPlan(String programAndPlan) {
		this.programAndPlan = programAndPlan;
	}

	public String getAcademicLevel() {
		return academicLevel;
	}

	public void setAcademicLevel(String academicLevel) {
		this.academicLevel = academicLevel;
	}

	public String getAsurite() {
		return asurite;
	}

	public void setAsurite(String asurite) {
		this.asurite = asurite;
	}

	/**
	 * Needs to be implemented by Decorator Class
	 */
	@Override
	public void addGrade(Decorator62GradeBean grade) {

	}

	/**
	 * Needs to be implemented by Decorator Class
	 */
	@Override
	public List<Decorator62GradeBean> getGrades() {
		return null;
	}

	/**
	 * Needs to be implemented by Decorator Class
	 */
	@Override
	public void addAttendance(Decorator62AttendanceBean attendance) {

	}

	/**
	 * Needs to be implemented by Decorator Class
	 */
	@Override
	public List<Decorator62AttendanceBean> getAllAttendance() {
		return null;
	}

	@Override
	public String toString() {
		return "SimpleStudent62 [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", programAndPlan="
				+ programAndPlan + ", academicLevel=" + academicLevel + ", asurite=" + asurite + "]";
	}

}
