package team1.sukhpreet;

/**
 * sukhpreet.Decorator12Grades is the concrete decorator subclass extending
 * sukhpreet.Decorator12AbstractDecorator and is responsible for adding student grade
 * information to the Student object along with the core data
 * as a part of the Decorator design pattern
 *
 * @author  Sukhpreet Anand
 * @version 1.1
 * @since   10-28-2020
 */

import java.util.List;

public class Decorator12Grades extends Decorator12AbstractDecorator {
	
	private String assignmentName;
	private float score;
	private float maxScore;
	
	public Decorator12Grades(String assignmentName, float score, float maxScore) {
		this.assignmentName = assignmentName;
		this.maxScore = maxScore;
		this.score = score;
	}
	
	@Override
	public void add(Decorator12 student) {
		super.add(student);
	}

	@Override
	public List<Decorator12SingleGrade> getGrades() {
		List<Decorator12SingleGrade> list = super.getGrades();
		list.add(new Decorator12SingleGrade(assignmentName, (score/maxScore)*100));
		return list;
	}

	@Override
	public List<Decorator12SingleAttendance> getAttendance() {
		return super.getAttendance();
	}

}
