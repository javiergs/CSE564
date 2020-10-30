import java.util.LinkedList;

/*
Author: Anurag Mishra
File Version: 1.0
Time required: 6 hours
*/
public class Main72 {
    public static void main(String[] args) {
	Student71 newStudent= new StudentCoreData72("1230321,Ria,Mehta,Software Engineering MS,Graduate,rnmehta1");
	//adding decorator pattern objects
	StudentAttendance72Decorator attendanceCard = new StudentAttendance72Decorator ("10/26", 72);
	StudentAttendance72Decorator attendanceCard2 = new StudentAttendance72Decorator ("10/27", 11);
	StudentAttendance72Decorator attendanceCard3 = new StudentAttendance72Decorator ("10/28", 30);
	StudentGrades72Decorator gradesCard = new StudentGrades72Decorator ("Quiz 1", 75, 100); //75%
	StudentGrades72Decorator gradesCard2 = new StudentGrades72Decorator ("Quiz 2", 75, 100); //75%
	StudentGrades72Decorator gradesCard3 = new StudentGrades72Decorator ("Quiz 3", 79, 100); //79%

	//StudentGrades72Decorator gradesCard2 = new StudentGrades72Decorator ("Quiz 2", 75, 100); //75%
	/* each decorator object corresponds to one row in either the grades csv or attendance csv. every new row, create an object ,
	add in the data and add it an already **existing decorator** object. If none exist, add the student whose info this is related to the decorator.
	Use the very 1st decorator object's printVlaue method to obtain all info about the student.*/
	gradesCard.add(attendanceCard);
    attendanceCard.add(newStudent);
    gradesCard.printValue();
    

    LinkedList<Grades72> grades_List = StudentGrades72Decorator.grades;
	System.out.println(grades_List.size());
	if (grades_List.size() > 0) {
		for (Grades72 gList : grades_List) {
			System.out.println(gList.getResult());
		}
	}
	LinkedList<Attendance72> attendance_List = StudentAttendance72Decorator.attendanceList;
	System.out.println("attendance size- " + attendance_List.size());
	if (attendance_List.size() > 0) {
		for (Attendance72 attList : attendance_List) {
			System.out.println(attList.getMinutes());
		}
	}
	/* Here we are taking the (grade/attendance)list from decorator object and storing it in student object itself. 
	 * Then we clear the static list present in the decorator object to ensure that when the code flow creates a new student object, the 
	 * student is able to add (grade/attendance)objects to those linked lists*/
	 newStudent.setGrades(gradesCard.getGrades());// storing student wise
	 System.out.println("Student object grades are : " + newStudent.getGrades());
	 
	 StudentGrades72Decorator.grades.clear();
	 StudentAttendance72Decorator.attendanceList.clear();
	 
	 System.out.println(" student object grades after clearing decorator are " +newStudent.getGrades());
	 
	 LinkedList<Grades72> grades_List2 = StudentGrades72Decorator.grades;
		System.out.println(grades_List.size());
		if (grades_List2.size() > 0) {
			for (Grades72 gList : grades_List) {
				System.out.println(gList.getResult());
			}
		}else {
			System.out.println("grade list clear");
		}
		
		LinkedList<Attendance72> attendance_List2 = StudentAttendance72Decorator.attendanceList;
		System.out.println("attendance size- " + attendance_List.size());
		if (attendance_List2.size() > 0) {
			for (Attendance72 attList : attendance_List) {
				System.out.println(attList.getMinutes());
			}
		}else {
			System.out.println("attendance list clear");
		}
		
		System.out.println(" student grades are " +newStudent.getGrades());
	
    System.out.println("                      *Now for a new student*                           ");
    
	Student71 newStudent2= new StudentCoreData72("1230322,Anurag,Mishra,Software Engineering MS,Graduate,amishr57");
    StudentAttendance72Decorator attendanceCard7 = new StudentAttendance72Decorator ("10/26", 78);
    StudentAttendance72Decorator attendanceCard8 = new StudentAttendance72Decorator ("10/27", 78);
    StudentAttendance72Decorator attendanceCard9 = new StudentAttendance72Decorator ("10/28", 78);
	StudentGrades72Decorator gradesCard7 = new StudentGrades72Decorator ("Quiz 2", 50, 100); //50%
	StudentGrades72Decorator gradesCard8 = new StudentGrades72Decorator ("Quiz 3", 51, 100); //51% 
	
	gradesCard7.add(attendanceCard7);
    attendanceCard7.add(newStudent2);
    gradesCard7.printValue();
	

    LinkedList<Grades72> grades_List3 = StudentGrades72Decorator.grades;
	System.out.println(grades_List3.size());
	if (grades_List3.size() > 0) {
		for (Grades72 gList : grades_List3) {
			System.out.println(gList.getResult());
		}
	}
	LinkedList<Attendance72> attendance_List3 = StudentAttendance72Decorator.attendanceList;
	System.out.println("attendance size- " + attendance_List3.size());
	if (attendance_List3.size() > 0) {
		for (Attendance72 attList : attendance_List3) {
			System.out.println(attList.getMinutes());
		}
	}
	newStudent2.setGrades(gradesCard.getGrades());// storing student wise
	System.out.println(newStudent2.getGrades());
	
	StudentGrades72Decorator.grades.clear();
	StudentAttendance72Decorator.attendanceList.clear();
	
	System.out.println(" student object grades after clearing are " +newStudent2.getGrades());
	
    System.out.println("==================================================");
    


    }
}
