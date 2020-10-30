package team1.sukhpreet;

/**
 * sukhpreet.Decorator12 is the interface for fetching Student details
 * as a part of the Decorator design pattern
 *
 * @author  Sukhpreet Anand
 * @version 1.1
 * @since   10-28-2020
 */

import java.util.ArrayList;
import java.util.List;

public abstract class Decorator12 {

	public abstract String getID();
	public abstract String getFirstName();
	public abstract String getLastName();
	public abstract String getProgram();
	public abstract String getLevel();
	public abstract String getAsurite();

	public List<Decorator12SingleGrade> getGrades() {
		List<Decorator12SingleGrade> list = new ArrayList<>();
		return list;
	}

	public List<Decorator12SingleAttendance> getAttendance() {
		List<Decorator12SingleAttendance> list = new ArrayList<>();
		return list;
	}

	public String toString() {
		return String.format("ID: " + getID() + ", Name: " + getFirstName() + " " + getLastName() + ", Program: " + getProgram() + ", Level: " + getLevel() + ", ASURITE: " + getAsurite());
	}
}

