import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Decorator22 {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
		Decorator22Student javier = new Decorator22StudentDecorator();
		javier.add(new Decorator22StudentCoreData());
    	Decorator22StudentAttendance attendanceCard = new Decorator22StudentAttendance("10-22",85);
    	Decorator22StudentGrades gradesCard1 = new Decorator22StudentGrades("Quiz 1", 100);
    	Decorator22StudentGrades gradesCard2 = new Decorator22StudentGrades("Assignment 1", 95);
    	javier.setFirstName("Javier");
    	javier.setLastName("Gonzalez");
    	javier.setId(1210101010);
    	javier.setProgram("Computer Science");
    	javier.setLevel("Graduate");
    	javier.setAsurite("javiergs");
	
    	javier.addAttendance(attendanceCard);
    	javier.addGrades(gradesCard1);
    	javier.addGrades(gradesCard2);
    	System.out.println("\n*****Student Core Data*****\n");
    	System.out.println("ID - " + javier.getId());
    	System.out.println("Name - " + javier.getFirstName() + " " + javier.getLastName());
    	System.out.println("Program - " + javier.getProgram());
    	System.out.println("Level - " + javier.getLevel());
    	System.out.println("Asurite - " + javier.getAsurite());
    	System.out.println("\n*****Student Attendance Data*****\n");
    	ArrayList<Decorator22StudentAttendance> attCardTemp = javier.getAttendanceList();
    	SimpleDateFormat formatter1=new SimpleDateFormat("MM-dd-yyyy");
    	String d2 = attCardTemp.get(0).date + "-2020";
    	Date date1 = formatter1.parse(d2);
    	System.out.println("Date - " + date1);
    	System.out.println("Time - " + attCardTemp.get(0).min);
    	System.out.println("\n*****Student Grades Data*****\n");
    	ArrayList<Decorator22StudentGrades> gradCardTemp = javier.getGradesList();
    	System.out.println("Name - " + gradCardTemp.get(0).name);
    	System.out.println("Score - " + gradCardTemp.get(0).score);
    	System.out.println("Name - " + gradCardTemp.get(1).name);
    	System.out.println("Score - " + gradCardTemp.get(1).score);
    	
	}

}