/*
Author: Anurag Mishra
File Version: 1.0
Time required: 6 hours
*/

public class StudentAttendance72Decorator extends Student72Decorator {
	
	public Attendance72 attendValue = new Attendance72();
	
	public StudentAttendance72Decorator(String date,int minutes) {
		this.attendValue.setDate(date);
		this.attendValue.setMinutes(minutes);
		addStudentAttendance(); //calling the constructor ensures the attendance object is added to the linked list present in the parent class
	}
	
	@Override
    public void printValue(){
		super.printValue();
		printStudentAttendance();
    }
	
	public void printStudentAttendance() {
		for (Attendance72 attendObject : super.getAttendanceList() ) {
			System.out.println("Date: " + attendObject.getDate() + " and minutes attended: " + attendObject.getMinutes());	
		}
	}
	
	public void addStudentAttendance() {
		
		super.setAttendanceList(attendValue);
	}

}
