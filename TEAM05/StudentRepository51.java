import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class StudentRepository51 extends Observable {
	private  List<Student52> students = new ArrayList<>() ;

    public StudentIterator51 getIterator() {
        return new StudentStudentIterator51();
    }

    public void updateRepository(List<Student52> students) {
    	this.students = students;
    	setChanged();
        notifyObservers();
    }
    
    public void addStudent(List<Student52> students) {
		this.students.addAll(students);
		setChanged();
        notifyObservers();
	}
    
    private class StudentStudentIterator51 implements StudentIterator51 {

        int index;

        public boolean hasNext() {
            if(index < students.size()){
                return true;
            }
            return false;
        }

        public Object next() {
            if(this.hasNext()){
                return students.get(index++);
            }
            return null;
        }
    }
    
    
}