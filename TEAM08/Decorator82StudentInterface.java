import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Student abstract class 
 * CSE 564 - Assignment 4
 * Team 8 - Member 2 (ID 82)
 * Deepti Paul (dpaul9)
 * 26 Oct. 2020
 */

public abstract class Decorator82StudentInterface {
    
	public Map<String, Object> decorations = new LinkedHashMap<>();
	public Object get(String key) {
		return decorations.get(key); 
	}
	public void add(Object object) {}
	public abstract String getIdentificationNum();
	public abstract String getFirstName();
	public abstract String getLastName();
	public abstract String getProgramAndPlan();
	public abstract String getAcademicLevel();
	public abstract String getAsurite();
	
 
}
