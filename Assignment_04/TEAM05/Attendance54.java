/**
* The class is a POJO of Student Attendance data 
*
* @author  Nevedita Kailasam
* Time taken - 4 hours (including meeting with the team)
* 
*/
public class Attendance54 {

    public String date;
    public String minutes;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMinutes() {
        return minutes;
    }

    public void setMinutes(String minutes) {
        this.minutes = minutes;
    }

	@Override
	public String toString() {
		return "Attendance [date=" + date + ", minutes=" + minutes + "]";
	}
    
}