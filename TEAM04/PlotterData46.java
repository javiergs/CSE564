import java.util.ArrayList;

/**
* This class is a wrapper for storing the student data to be plotted.
*
* @author  Idhant Haldankar
* @id ihaldank
*/
public class PlotterData46 {
	String studentName;
	String academicLevel;
	ArrayList <GradesModel42> arr;
	int attendance;

	public void setAcademicLevel(String academicLevel) {
		this.academicLevel = academicLevel;
	}
	
	public void setName(String firstName, String lastName) {
		this.studentName = firstName + " " + lastName;
	}
	
	public void setGrades(ArrayList<GradesModel42> arr) {
		this.arr = arr;
	}

	public void setAttendance(int attendance) {
		this.attendance = attendance;
	}
	
	public String getStudentName() {
		return this.studentName;
	}
	public String getAcademicLevel() {
		return this.academicLevel;
	}
	public ArrayList<GradesModel42> getGrades() {
		return this.arr;
	}
	public int getAttendance() {
		return this.attendance;
	}
}
