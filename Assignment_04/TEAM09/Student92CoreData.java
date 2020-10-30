/**
 * @author rohitksingh
 * @version 1.0
 * @Date Modified 10/25/2020
 */
public class Student92CoreData extends Student92Model {

	Student92CoreData(String studentID, String firstName, String lastName, String studentProgram,
			String studentAcademicLevel, String studentAsurite) {
		this.studentID = studentID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentProgram = studentProgram;
		this.studentAcademicLevel = studentAcademicLevel;
		this.studentAsurite = studentAsurite;
	}

	public String getStudentID() {
		return studentID;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getStudentProgram() {
		return studentProgram;
	}

	public String getStudentAcademicLevel() {
		return studentAcademicLevel;
	}

	public String getStudentAsurite() {
		return studentAsurite;
	}

}