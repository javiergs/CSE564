package team1.sukhpreet; 

/**
 * sukhpreet.Decorator12Attendance is the concrete decorator subclass extending
 * sukhpreet.Decorator12AbstractDecorator and is responsible for adding student attendance
 * information to the Student object along with the core data
 * as a part of the Decorator design pattern
 *
 * @author  Sukhpreet Anand
 * @version 1.1
 * @since   10-28-2020
 */


import java.util.List;

public class Decorator12Attendance extends Decorator12AbstractDecorator {
	
	private String date;
	private float minutes;

	public Decorator12Attendance(String date, float minutes) {
		this.date = date;
		this.minutes = minutes;
	}
	
	@Override
	public void add(Decorator12 student) {
		super.add(student);
	}

	@Override
	public List<Decorator12SingleGrade> getGrades() {
		return super.getGrades();
	}

	@Override
	public List<Decorator12SingleAttendance> getAttendance() {
		List<Decorator12SingleAttendance> list = super.getAttendance();
		list.add(new Decorator12SingleAttendance(date, minutes));
		return list;
	}

}
