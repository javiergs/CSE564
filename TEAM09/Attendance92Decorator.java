/**
 * @author rohitksingh
 * @version 1.0
 * @Date Modified 10/25/2020
 */
public class Attendance92Decorator extends Decorator92 {

	public Attendance92Decorator(Student92Model student) {
		super(student);
	}

    //Adds Attendance object or List<Attendance> object in Student92Model
	@Override
	public void add(Object object) {
		decorators.put("Attendance", object);
	}

}
