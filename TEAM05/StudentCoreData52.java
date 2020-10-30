import java.util.List;

//author :- Sakshi Jain
public class StudentCoreData52 implements Student52 {

    private String name;
    private String program;
    private String level;
    private String asurite;

    @Override
    public String getAsurite() {
        return this.asurite;
    }

	public StudentCoreData52(String asurite, String name, String program, String level) {
		this.name = name;
		this.program = program;
		this.level = level;
		this.asurite = asurite;
	}

	public String getName() {
		return name;
	}

	public String getProgram() {
		return program;
	}

	public String getLevel() {
		return level;
	}
	
	public List<Attendance54> getAttendance() {
		return null;
	};

    public List<Grade53> getGrades(){
    	return null;
    };

}
