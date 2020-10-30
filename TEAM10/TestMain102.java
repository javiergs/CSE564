/**
 * Time taken to implement ~ 1.5 hours.
 * 
 * @author Nitish Tripathi
 *
 */

public class TestMain102 {
	public static void main(String[] args) {
		Decorator102StudentCoreData student = new Decorator102StudentCoreData("1219500269", "Nitish","Tripathi","M. S., CSE ASU 2022","Masters","ntripat7");
		Decorator102StudentAttendance attendanceCard = new Decorator102StudentAttendance();
		Decorator102StudentGrade gradesCard = new Decorator102StudentGrade();

		attendanceCard.addAttendance("08/20/2020", 75);
		attendanceCard.addAttendance("08/21/2020", 75);
		
		gradesCard.addStudentGrade("Quiz 1", 100, 100);
		gradesCard.addStudentGrade("Quiz 2", 95, 100);
		
		attendanceCard.add(student);
		gradesCard.add(attendanceCard);
		System.out.println(gradesCard.getInfo());
	}
}

// as of now 1.5 hours