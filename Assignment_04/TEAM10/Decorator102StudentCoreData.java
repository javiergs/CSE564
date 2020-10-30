/**
 * Time taken to implement ~ 1.5 hours.
 * 
 * @author Nitish Tripathi
 *
 */

public class Decorator102StudentCoreData extends Decorator102Student {
	
	private String id;
	private String firstName;
	private String lastName;
	private String programAndPlan;
	private String academicLevel;
	private String asurite;
	
	public Decorator102StudentCoreData(String id, String firstName, String lastName, String programAndPlan, String academicLevel,
			String asurite) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.programAndPlan = programAndPlan;
		this.academicLevel = academicLevel;
		this.asurite = asurite;
	}
	public String getId() {
		return id;
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
	@Override
	public String getAsurite() {
		return asurite;
	}

	@Override
	public String getInfo() {
		return id+" "+firstName+" "+lastName+" "+programAndPlan+" "+academicLevel+" ;"+asurite + " ";
	}
}
