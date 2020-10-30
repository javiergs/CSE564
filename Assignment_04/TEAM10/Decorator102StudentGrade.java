/**
 * Time taken to implement ~ 1.5 hours.
 * 
 * @author Nitish Tripathi
 *
 */

import java.util.*;

public class Decorator102StudentGrade extends Decorator102{
	protected String quizName;
	protected int studentMarks;
	protected int finalMarks;
	
	List<String[]> marks = new ArrayList<String[]>();
	
	public void addStudentGrade(String quizName, int studentMarks, int finalMarks) {
		this.quizName = quizName;
		this.studentMarks = studentMarks;
		this.finalMarks = finalMarks;
		marks.add(new String[] {quizName, String.valueOf(studentMarks), String.valueOf(finalMarks)});
	}
	
	@Override
	public String getInfo() {
		String coreData =  super.getInfo();
		String grades = "";
		for (String[] row : marks) {
	        grades += Arrays.toString(row) + ", ";
	    }
		
		return coreData + ";" +  grades;
	}

	@Override
	public String getAsurite() {
		return super.getAsurite();
	}

}
