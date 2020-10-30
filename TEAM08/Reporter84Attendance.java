/**
 * CSE564- Team 8 Reporter84Attendance class responsible for constructing object
 * for student's attendance
 * 
 * @author-Sarvansh Prasher
 * @number- 84 @date-10/26/2020 @version-1.0
 */
public class Reporter84Attendance {

	private String date;
	private String min;

	public Reporter84Attendance(String date, String min) {
		this.date = date;
		this.min = min;
	}

	public String getDate() {
		return date;
	}

	public String getMin() {
		return min;
	}

	public String toString() {
		return date + " , " + min;
	}

}
