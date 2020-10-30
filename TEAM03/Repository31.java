package src;
import java.io.File;
import java.util.*;
/**@author Aditya Das
 * 
 *@since 2020-10-23 Approximate time taken : 4 hours (excluding 1.5 hours meeting)
 *
 */

public class Repository31 extends Observable implements Repository31Visitable {

    private static Repository31 repository;
    protected Map<String, Decorator32> students = new HashMap<String, Decorator32>();

    private Repository31() {
    }

    public static Repository31 getInstance() {
        if (repository == null) {
            repository = new Repository31();
        }
        return repository;
    }

    @Override
    public void accept(Repository31Visitor studentVisitor) {
        for(Decorator32 i: students.values()) {
            i.accept(studentVisitor);
        }
        setChanged();
        notifyObservers(students);
    }




    public void setRoster(String filename) {
        boolean firstLine = true;
        Decorator32 coreStudentObj = null;
        try (Scanner scanner = new Scanner(new File(filename))) {
            String inpLine;
            while (scanner.hasNextLine()) {
                inpLine = scanner.nextLine();
                if(!inpLine.trim().isEmpty()) {
                    if (!firstLine) {
                        String[] lineArr = inpLine.split(",");

                        String id = lineArr[0];
                        String firstName = lineArr[1];
                        String lastName = lineArr[2];
                        String program = lineArr[3];
                        String academicLevel = lineArr[4];
                        String asurite = lineArr[5];

                        coreStudentObj = Decorator32StudentFactory.makeCoreStudent(id, firstName, lastName, program,
                                academicLevel, asurite);

                        students.put(asurite,(Decorator32) coreStudentObj);
                    }
                }
                firstLine = false;
            }
            setChanged();
            notifyObservers(students);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}




