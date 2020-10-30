import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * @author srinivasan
 * @since 10/28/2020
 * Controller class to control the data flow and update the view
 */
public class Main97Controller {

    private final Student91Observable studentRepo;
    private final Grader93 grader;
    private final Reporter94 reporter;

    Main97Controller(JFrame frame){
        studentRepo =  Student91Observable.getInstance();
        grader = new Grader93();
        reporter = new Reporter94();
        ObserverPlotter96 graphObserver = new ObserverPlotter96();
        ObserverTable95 tableObserver = new ObserverTable95();
        studentRepo.addObserver(graphObserver);
        studentRepo.addObserver(tableObserver);
        frame.add(graphObserver, BorderLayout.SOUTH);
        frame.add(tableObserver, BorderLayout.CENTER);
    }

    public void rosterController(){
        studentRepo.init_Iterator(openFile());
    }

    public void gradeController(){
        grader.gradeStudents(openFile());
    }

    public void attendanceController(){
        reporter.studentAttendance(openFile());
    }

    public String openFile(){
        JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir"));
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            return selectedFile.getPath();
        }
        return null;
    }
}
