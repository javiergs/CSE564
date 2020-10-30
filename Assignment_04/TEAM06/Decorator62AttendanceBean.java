
/**
 * A Bean class which representing a student's single attendance instance (date and minutes) 
 * 
 * @author Akhilesh Krishnan (akrish84)
 * @since 10/25/2020
 *
 */
public class Decorator62AttendanceBean implements Cloneable {

	private String date;
	private int minutes;

	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	@Override
	public String toString() {
		return "Attendance62 [date=" + date + ", minutes=" + minutes + "]";
	}
}
