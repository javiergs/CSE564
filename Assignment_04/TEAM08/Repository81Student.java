/**
 * Student Class
 * CSE 564 - Assignment 4
 * Team 8 - Member 1 (ID 81)
 * Amodini Pathak (acpatha1)
 * 28 Oct. 2020
 */

public class Repository81Student extends Decorator82StudentInterface{

    private String identificationNum;
    private String firstName;
    private String lastName;
    private String programAndPlan;
    private String academicLevel;
    private String asurite;

    public Repository81Student(String identificationNum, String firstName, String lastName, String programAndPlan, String academicLevel, String asurite) {
        this.identificationNum = identificationNum;
        this.firstName = firstName;
        this.lastName = lastName;
        this.programAndPlan = programAndPlan;
        this.academicLevel = academicLevel;
        this.asurite = asurite;
    }

    public String getIdentificationNum() {
        return identificationNum;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getProgramAndPlan() {
        return programAndPlan;
    }

    public String getAcademicLevel() {
        return academicLevel;
    }

    public String getAsurite() {
        return asurite;
    }

    public String toString() {
		return identificationNum + " , " + firstName + " , " + lastName + " , " + programAndPlan + " , " + academicLevel + " , " + asurite;
	}
}
