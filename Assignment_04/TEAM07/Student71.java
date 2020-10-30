/*
Author: Ria Mehta
File Version: 2.0
Time required: 5 hours
Description: Student71 Class stores information about student71s.
Input: Data from StudentRepository71Iterator
Output: Gives Information through Public methods.
*/


import java.util.LinkedList;
import java.util.Observable;

public abstract class Student71 extends Observable {
	
    // Getter functions for student Info
    public abstract String getId();
    
    public abstract String getFirst_name();
    
    public abstract String getLast_name();

    public abstract String getProgramPlan();

    public abstract String getAcademic_level();
    
    public abstract String getAsurite();
    
    public abstract LinkedList<Grades72> getGrades();
    
    public abstract LinkedList<Attendance72> getAttendanceList();

    //Setter Functions for student info
    
	public void setGrades(LinkedList<Grades72> grades) {
		notifyObservers();
	}


	public void setAttendanceList(LinkedList<Attendance72> attendanceList) {
		notifyObservers();
	}
	
    public void setFirst_name(String first_name) {
    	 notifyObservers();
    }

    public void setLast_name(String last_name) {
    	notifyObservers();
    }

    public void setProgramPlan(String programPlan) {
    	notifyObservers();
    }

    public void setAcademic_level(String academic_level) {
    	notifyObservers();
    }

    public void setAsurite(String asurite) {
    	notifyObservers();
    }

    public void printValue(){
        System.out.println("ID: "+ getId());
        System.out.println("Name: " + getFirst_name()+ " "+ getLast_name());
        System.out.println("Program and Plan: " + getProgramPlan());
        System.out.println("Academic Level: " + getAcademic_level());
        System.out.println("Asurite: " + getAsurite());
    }
}
