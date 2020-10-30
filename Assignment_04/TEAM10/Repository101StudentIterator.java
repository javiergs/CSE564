/**
 * Repository101StudentIterator implements the Repository101Iterator for retrieving student details.
 * Time taken to implement ~ 2 hours.
 * 
 * @author Tanveer
 * @version 1.1
 * @since 10-24-2020
 *
 */
import java.util.ArrayList;
import java.util.List;

public class Repository101StudentIterator implements Repository101Iterator {
	
	List<Decorator102Student> students = new ArrayList<Decorator102Student>();

	int index;

	public Repository101StudentIterator(List<Decorator102Student> students) {
		this.students = students;
	}

	@Override
	public boolean hasNext() {
		 if(index < students.size()){
	            return true;
	         }
		return false;
	}

	@Override
	public Object next() {
		 if(this.hasNext()){
	            return students.get(index++);
	         }
		return null;
	}
	@Override
	public Decorator102Student peek() {
		return students.get(index);
	}
	@Override
	public void setNext(Object student) {
		students.set(index++, (Decorator102Student) student);
	}
	
	

}
