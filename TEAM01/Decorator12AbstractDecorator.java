package team1.sukhpreet; 

/**
 * sukhpreet.Decorator12AbstractDecorator is the abstract decorator class extending
 * sukhpreet.Decorator12 and is responsible for decorating extra
 * student information to the Student object along with the core data
 * as a part of the Decorator design pattern
 *
 * @author  Sukhpreet Anand
 * @version 1.1
 * @since   10-28-2020
 */


import java.util.List;

public class Decorator12AbstractDecorator extends Decorator12 {
	
	protected Decorator12 student;
	
	public void add(Decorator12 student) {
		this.student = student;
	}

	@Override
	public String getID() {
		return student.getID();
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
	public String getProgram() {
		return student.getProgram();
	}

	@Override
	public String getLevel() {
		return student.getLevel();
	}

	@Override
	public String getAsurite() {
		return student.getAsurite();
	}

	@Override
	public List<Decorator12SingleGrade> getGrades() {
		return student.getGrades();
	}

	@Override
	public List<Decorator12SingleAttendance> getAttendance() {
		return student.getAttendance();
	}

	@Override
	public String toString() {
		String data = super.toString();
		return data + "\n" + getGrades() + "\n" + getAttendance().toString();
	}

}
