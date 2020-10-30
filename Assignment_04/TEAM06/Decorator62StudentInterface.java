import java.util.List;

/**
 * 
 * 
 * Student Interface that will be exposed to all modules to access/set student attributes 
 * 
 * @author Akhilesh Krishnan (akrish84)
 * @since 10/25/2020
 *
 */
public interface Decorator62StudentInterface {

	public long getId();

	public void setId(long id);

	public String getFirstName();

	public void setFirstName(String firstName);

	public String getLastName();

	public void setLastName(String lastName);

	public String getProgramAndPlan();

	public void setProgramAndPlan(String programAndPlan);

	public String getAcademicLevel();

	public void setAcademicLevel(String academicLevel);

	public String getAsurite();

	public void setAsurite(String asurite);

	public void addGrade(Decorator62GradeBean grade);

	public List<Decorator62GradeBean> getGrades();

	public void addAttendance(Decorator62AttendanceBean attendance);

	public List<Decorator62AttendanceBean> getAllAttendance();

}
