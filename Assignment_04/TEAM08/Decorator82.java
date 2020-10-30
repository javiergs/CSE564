import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Student Decorator Class
 * CSE 564 - Assignment 4
 * Team 8 - Member 2 (ID 82)
 * Deepti Paul (dpaul9)
 * Total Time taken for Development and Testing = 3.5 hours
 */

public class Decorator82 extends Decorator82StudentInterface{
	
	public Decorator82StudentInterface student;

	public Decorator82(Decorator82StudentInterface student) {
		decorations = student.decorations;
		this.student = student;
	}

	@Override
	public String getIdentificationNum() {
		return student.getIdentificationNum();
	}

	@Override
	public String getFirstName() {
		return student.getFirstName();
	}

	@Override
	public String getLastName() {
		return student.getLastName();
	}


	@Override
	public String getProgramAndPlan() {
		return student.getProgramAndPlan();
	}


	@Override
	public String getAcademicLevel() {
		return student.getAcademicLevel();
	}

	@Override
	public String getAsurite() {
		return student.getAsurite();
	}

	public String toString() {
		return student.toString() + decorations.get("Attendance") + " , " + decorations.get("Grades");
	}

	

}
