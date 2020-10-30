/**
 * StudentGrades that extends from the Decorator class
 * CSE 564 - Assignment 4
 * Team 8 - Member 2 (ID 82)
 * Deepti Paul (dpaul9)
 */

public class Decorator82StudentGrades extends Decorator82{
	
	public Decorator82StudentGrades(Decorator82StudentInterface student) {
		super(student); 
	}
	
	@Override
	public void add(Object object) {
		decorations.put("Grades", object);
	}
}
