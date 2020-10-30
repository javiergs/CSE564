import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class StudentRepository21 extends Observable implements Container21 {

    private String subjectState;
    public StudentRepository21() {
    	return;
    }

    public String getState() {
        return subjectState;
    }

    public void setState(String subjectState) {
        this.subjectState = subjectState;
    }

    public List<Object> students = new ArrayList<>();

    public StudentRepository21(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (i > 0 && values.length > 1) {
               //     Decorator22StudentCoreData newStudent = new Decorator22StudentCoreData();
                	Decorator22Student newStudent = new Decorator22StudentDecorator();
                    newStudent.add(new Decorator22StudentCoreData());

                	newStudent.setId(Integer.parseInt(values[0]));
                    newStudent.setFirstName(values[1]);
                    newStudent.setLastName(values[2]);
                    newStudent.setProgram(values[3]);
                    newStudent.setLevel(values[4]);
                    newStudent.setAsurite(values[5]);
                    
                    students.add(newStudent);
                    notifyObservers();
                }
                i++;
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void addGradess(int i){
        Decorator22StudentCoreData newStudent = new Decorator22StudentCoreData();
        newStudent.setId(1);
        newStudent.setFirstName("3");
        newStudent.setLastName("4");
        newStudent.setProgram("5");
        newStudent.setLevel("6");
        newStudent.setAsurite("7");
        students.add(newStudent);
        notifyObservers();
    }
    @Override
    public Iterator21 getIterator() {
        return new StudentIterator();
    }

    private class StudentIterator implements Iterator21 {

        int index = 0;

        @Override
        public boolean hasNext() {

            if (this.index < students.size()) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {

            if (this.hasNext()) {
                this.index += 1;
                return students.get(this.index - 1);
            }
            return null;
        }
    }

    @Override
    public void notifyObservers() {
        setChanged();
        notifyObservers(null);
    }
}
