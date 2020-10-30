import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Iterator Pattern Concrete (Student) Repository
 * CSE 564 - Assignment 4
 * Team 8 - Member 1 (ID 81)
 * Amodini Pathak (acpatha1)
 * 28 Oct. 2020
 */

public class Repository81StudentRepository extends Observable implements Repository81 {

    private ArrayList<Decorator82StudentInterface> students;

    /*
    * FileNotFoundException and IOException passed up to caller so that appropriate UI message can be
    * displayed and user has chance to select a different file.
    */
    public Repository81StudentRepository(String filepath) throws IOException {
        students = new ArrayList<Decorator82StudentInterface>();
        readFile(filepath);
        setChanged();
    }

    public void isChanged() {
        setChanged();
    }

    private void readFile(String filepath) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(filepath));
        fileReader.readLine();  //Skip header row
        String currentLine;
        while ((currentLine = fileReader.readLine()) != null) {
            if (currentLine.length() != 0) {
                parseStudent(currentLine);
            }
        }
        fileReader.close();
    }

    private void parseStudent(String studentLine) {
        String[] values = studentLine.split(",", -1);
        String identificationNum = values[0];
        String firstName = values[1];
        String lastName = values[2];
        String programAndPlan = values[3];
        String academicLevel = values[4];
        String asurite = values[5];
        try {
            Repository81StudentBuilder studentBuilder = new Repository81StudentBuilder();
            studentBuilder.setIdentificationNum(identificationNum);
            studentBuilder.setFirstName(firstName);
            studentBuilder.setLastName(lastName);
            studentBuilder.setProgramAndPlan(programAndPlan);
            studentBuilder.setAcademicLevel(academicLevel);
            studentBuilder.setAsurite(asurite);
            students.add(studentBuilder.getResult());
        } catch (NotImplementedException exception) {
            System.out.println("Incomplete student record for: \n\"" + studentLine + "\"\nStudent not added to repository.\n");
        }
    }

    public void replaceStudent(Decorator82StudentInterface student, String asurite) {
        Repository81Iterator iter = getIterator();
        int i = 0;
        while (iter.hasNext()) {
            Decorator82StudentInterface st = (Decorator82StudentInterface) iter.next();
            if (st.getAsurite().equals(asurite)) {
                students.set(i, student);
            }
            i++;
        }
    }

    @Override
    public Repository81Iterator getIterator() {
        return new Repository81StudentIterator();
    }

    /**
     * Iterator Pattern Concrete (Student) Iterator
     * CSE 564 - Assignment 4
     * Team 8 - Member 1 (ID 81)
     * Amodini Pathak (acpatha1)
     * 25 Oct. 2020
     */
    
    private class Repository81StudentIterator implements Repository81Iterator{
        
        int index;

        @Override
        public boolean hasNext() {
            if (index < students.size()) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public Object next() {
            if (hasNext()) {
                return students.get(index++);
            } else {
                return null;
            }
        }

    }
    
}
