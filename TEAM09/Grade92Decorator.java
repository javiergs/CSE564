/**
 * @author rohitksingh
 * @version 1.0
 * @Date Modified 10/25/2020
 */
public class Grade92Decorator extends Decorator92 {

	public Grade92Decorator(Student92Model student) {
		super(student);
	}

    //Adds Grade92Model object or List<Grade92Model> object in Student92Model
	@Override
	public void add(Object object) {
		decorators.put("Grade", object);
	}

}