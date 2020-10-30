/**
 * Time taken to implement ~ 1.5 hours.
 * 
 * @author Nitish Tripathi
 *
 */

import java.util.Arrays;
import java.util.HashMap;

public class Decorator102StudentAttendance extends Decorator102 {
	protected HashMap<String, Integer> attendance = new HashMap<String, Integer>();
	protected String date;
	protected int minutes;
	
	public void addAttendance(String date, int minutes) {
		this.date = date;
		this.minutes = minutes;
		if(!attendance.containsKey(date)){
			attendance.put(date, minutes);
        }
	}
	
	@Override
	public String getInfo() {
		String attendanceString = ""+Arrays.asList(attendance);
		String coreData = super.getInfo();
		return coreData+ ";" + attendanceString;
	}
	
}
