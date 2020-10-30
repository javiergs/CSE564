package src;

/**
 * Main37 is the main file and handles the connections for the application
 *
 * @author  Sheran Dass
 * @version 1.0
 * @since   2019-10-24, number of hours = 3 hours - 1 1/2hr meeting 1 1/2 hour coding
 */

public class Main37 {
    public static void main(String[] args){
        Repository31 studentRepository = Repository31.getInstance();
        ObserverTable35 observerTable = new ObserverTable35();
        ObserverPlotter36 observerPlotter = new ObserverPlotter36();
        studentRepository.addObserver(observerTable);
        studentRepository.addObserver(observerPlotter);

        Main37RosterButtonListener rosterListener = new Main37RosterButtonListener();
        Main37GraderButtonListener graderListener = new Main37GraderButtonListener();
        Main37ReporterButtonListener reporterListener = new Main37ReporterButtonListener();
        Main37Frame frame = new Main37Frame("Assignment 4", observerPlotter, observerTable, rosterListener, graderListener, reporterListener);
    }
}
