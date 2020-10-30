import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Karandeep Singh Grewal - kgrewal2
 */
public class StudentRepository41 {
    private List<StudentCoreData42> studentsCoreData;

    public StudentRepository41() {
        studentsCoreData = new ArrayList<>();
    }

    public void addStudent(StudentCoreData42 studentCoreData42) {
        this.studentsCoreData.add(studentCoreData42);
    }

    public Iterator getIterator() {
        return new StudentIterator();
    }

    public class StudentIterator implements Iterator {
        private int index;

        @Override
        public boolean hasNext() {
            return index < studentsCoreData.size();
        }

        @Override
        public Object next() {
            if (this.hasNext())
                return studentsCoreData.get(index++);
            return null;
        }
    }
}
