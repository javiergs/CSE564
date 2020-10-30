import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Observable;

public class MainModel47 {
    private Repository41 repo;
    private Grader43 grader;
    private Reporter44 reporter;
    private ArrayList<String> filePaths;


    MainModel47(ArrayList<String> filePaths)
    {
        this.filePaths = filePaths;
        repo = new Repository41();
        grader = new Grader43();
        reporter = new Reporter44(filePaths.get(2));
        repo.readFile(filePaths.get(0));
    }

    public void decorateAttendance() {
        try {
            reporter.AddAttendanceDetails(repo);
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
        repo.updateObservers();
    }

    public void decorateGrades() {
        try {
         grader.loadFile(filePaths.get(1));
         } catch (FileNotFoundException fileNotFoundException) {
             fileNotFoundException.printStackTrace();
         }
        grader.loadDataToStudentRepository(repo);
        repo.updateObservers();
    }

    public ArrayList<Observable> getObservables() {
        ArrayList<Observable> observables = new ArrayList<Observable>();
        try {
            Class c = Class.forName(this.getClass().getName());
            Field fieldList[] = c.getDeclaredFields();
            for(int i = 0; i < fieldList.length; i++)
            {
                Field fld = fieldList[i];
                try {
                    Observable o = (Observable) fld.get(this);
                    observables.add(o);
                }
                catch(ClassCastException e) {
                }
            }
        }
        catch (Throwable e)
        {
            e.printStackTrace();
        }
        return observables;
    }

}
