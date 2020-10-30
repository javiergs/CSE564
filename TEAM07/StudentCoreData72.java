import java.util.LinkedList;

/*
/*
Author: Anurag Mishra
File Version: 1.0
Time required: 6 hours
*/


public class StudentCoreData72 extends Student71 {
    private String id;
    private String first_name;
    private String last_name;
    private String programPlan;
    private String academic_level;
    private String asurite;
    private String[] data;
    private LinkedList<Grades72> gradesList = new LinkedList<Grades72>();
	private LinkedList<Attendance72> attendanceList2 = new LinkedList<Attendance72>();

    public StudentCoreData72(String studentData){
        data=studentData.split(",");
        this.id=data[0];
        this.first_name=data[1];
        this.last_name=data[2];
        this.programPlan=data[3];
        this.academic_level=data[4];
        this.asurite=data[5];
    }

    // Getter functions for student Info
    public String getId(){
        return this.id;
    }
    public String getFirst_name(){
        return this.first_name;
    }
    public String getLast_name(){
        return this.last_name;
    }

    public String getProgramPlan(){
        return this.programPlan;
    }

    public String getAcademic_level(){
        return this.academic_level;
    }

    public String getAsurite(){
        return this.asurite;

    }

    //Setter Functions for student info
    public void setFirst_name(String first_name){
        this.first_name=first_name;
        notifyObservers();
    }

    public void setLast_name(String last_name){
        this.last_name=last_name;
        notifyObservers();
    }

    public void setProgramPlan(String programPlan){
        this.programPlan=programPlan;
        notifyObservers();
    }

    public void setAcademic_level(String academic_level){
        this.academic_level=academic_level;
        notifyObservers();
    }

    public void setAsurite(String asurite){
        this.asurite=asurite;
        notifyObservers();
    }

	public LinkedList<Grades72> getGrades() {
		return gradesList;
	}

	public void setGrades(LinkedList<Grades72> grades) {
		for (Grades72 grade : grades) {
		       Grades72 gradeNew = new Grades72();
		       gradeNew.setQuizName(grade.getQuizName());
		       gradeNew.setResult(grade.getResult());
		       gradeNew.setMaxMarks(grade.getMaxMarks());
		       gradesList.add(gradeNew);
		}
	}

	public LinkedList<Attendance72> getAttendanceList() {
		return attendanceList2;
	}

	public void setAttendanceList(LinkedList<Attendance72> attendanceList) {
		for (Attendance72 attendance : attendanceList) {
			   Attendance72 attendNew = new Attendance72();
			   attendNew.setDate(attendance.getDate());
			   attendNew.setMinutes(attendance.getMinutes());
			   attendanceList2.add(attendNew);
		}
	}

}
