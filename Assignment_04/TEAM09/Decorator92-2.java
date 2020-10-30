/**
 * @author rohitksingh
 * @version 1.0
 * @Date Modified 10/25/2020
 */
public class Decorator92 extends Student92Model {

	public Student92Model student;

    // Adds decoration on Student92Model 
	// and initializes the LinkedMap object with the pre-existing LinkedHashMap.
	public Decorator92(Student92Model student) {
		this.student = student;
		decorators = student.decorators;
	}

	@Override
	public String getStudentID() {
		return student.getStudentID();
	}

	@Override
	public String getFirstName() {
		return student.getFirstName();
	}

	@Override
	public String getLastName() {
		return student.getLastName();
	}

	@Override
	public String getStudentProgram() {
		return student.getStudentProgram();
	}

	@Override
	public String getStudentAcademicLevel() {
		return student.getStudentAcademicLevel();
	}

	@Override
	public String getStudentAsurite() {
		return student.getStudentAsurite();
	}

}