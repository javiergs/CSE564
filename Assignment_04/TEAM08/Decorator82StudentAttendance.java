/**
 * StudentAttendance that extends from the Decorator class
 * CSE 564 - Assignment 4
 * Team 8 - Member 2 (ID 82)
 * Deepti Paul (dpaul9)
 * 26 Oct. 2020
 */

public class Decorator82StudentAttendance extends Decorator82 {
	
	public Decorator82StudentAttendance(Decorator82StudentInterface student) {
		super(student); 
	}
	
	@Override
	public void add(Object object) {
		decorations.put("Attendance", object);
	}
	

}
