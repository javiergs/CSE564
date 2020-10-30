import java.util.List;

//author :- Sakshi Jain
public abstract class StudentDecorator52 implements Student52 {

    protected Student52 studentEntity;

    public void setStudent(Student52 studentEntity) {
        this.studentEntity = studentEntity;
    }

    @Override
    public String getAsurite() {
        return studentEntity.getAsurite();
    }
    
    public String getName() {
		return studentEntity.getName();
	}

	public String getProgram() {
		return studentEntity.getProgram();
	}

	public String getLevel() {
		return studentEntity.getLevel();
	}

    public abstract List<Attendance54> getAttendance();

    public abstract List<Grade53> getGrades();
}
