import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Builder Pattern Concrete (Student) Builder
 * CSE 564 - Assignment 4
 * Team 8 - Member 1 (ID 81)
 * Amodini Pathak (acpatha1)
 * 25 Oct. 2020
 */

public class Repository81StudentBuilder implements Repository81Builder {

    private String identificationNum;
    private String firstName;
    private String lastName;
    private String programAndPlan;
    private String academicLevel;
    private String asurite;

    public Repository81StudentBuilder() {
    }
    
    @Override
    public void setIdentificationNum(String pIdentificationNum) {
        this.identificationNum = pIdentificationNum;
    }
    
    @Override
    public void setFirstName(String pFirstName) {
        this.firstName = pFirstName;
    }

    @Override
    public void setLastName(String pLastName) {
        this.lastName = pLastName;
    }

    @Override
    public void setProgramAndPlan(String pProgramAndPlan) {
        this.programAndPlan = pProgramAndPlan;
    }

    @Override
    public void setAcademicLevel(String pAcademicLevel) {
        this.academicLevel = pAcademicLevel;
    }

    @Override
    public void setAsurite(String pAsurite) {
        this.asurite = pAsurite;
    }

    public Repository81Student getResult() throws NotImplementedException {
        if (this.identificationNum == null || this.firstName == null || this.lastName == null || this.programAndPlan == null || this.academicLevel == null || this.asurite == null) {
            throw new NotImplementedException();
        } else if (this.identificationNum.length() == 0 || this.firstName.length() == 0 || this.lastName.length() == 0 || this.programAndPlan.length() == 0 || this.academicLevel.length() == 0 || this.asurite.length() == 0 ) { 
            throw new NotImplementedException();
        } else {
            return new Repository81Student(this.identificationNum, this.firstName, this.lastName, this.programAndPlan, this.academicLevel, this.asurite);
        }
    }
}
