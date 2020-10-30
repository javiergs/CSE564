import java.util.LinkedHashMap;
import java.util.Map;

public abstract class Student92Model {

	public String studentID;
	public String firstName;
	public String lastName;
	public String studentProgram;
	public String studentAcademicLevel;
	public String studentAsurite;

	public Map<String, Object> decorators = new LinkedHashMap<String, Object>();

	public abstract String getStudentID();

	public abstract String getFirstName();

	public abstract String getLastName();

	public abstract String getStudentProgram();

	public abstract String getStudentAcademicLevel();

	public abstract String getStudentAsurite();

	public void add(Object object) {
	}

	public Object get(String key) {
		return decorators.get(key);
	}
}