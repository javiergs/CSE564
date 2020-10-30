package team1;


import org.jfree.util.Log;
import team1.aditya.Reporter14;
import team1.gaurav.Repository11;
import team1.nagarjun.Grader13;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Main17Controller class is controlling the listeners and initializing
 *
 * @author Shwetank Bhardwaj
 * @version 1.0
 * @since 10-25-2020
 */

public class Main17Controller {

    private Repository11 repository11;
    private Grader13 grader13;
    private Reporter14 reporter14;
    private Main17UI main17UI;

    public Main17Controller(Repository11 repository11, Grader13 grader13, Reporter14 reporter14, Main17UI main17UI) {
        main17UI.createUI();
        this.repository11 = repository11;
        this.grader13 = grader13;
        this.reporter14 = reporter14;
        this.main17UI = main17UI;
        this.main17UI.addRepoClickListener(new ButtonClickListener());
        this.main17UI.addGradeClickListener(new ButtonClickListener());
        this.main17UI.addAttendanceClickListener(new ButtonClickListener());
    }

    private void loadRoster() {
        String filePath = main17UI.selectFile();
        repository11.loadRoster(filePath);
    }

    public void loadGrades() {
        String filePath = main17UI.selectFile();
        grader13.loadGrades(filePath);
    }

    public void loadAttendance() {
        String filePath = main17UI.selectFile();
        reporter14.loadAttendance(filePath);
    }

    public class ButtonClickListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            try {
                String command = e.getActionCommand();
                switch (command) {
                    case "Open Student File":
                        loadRoster();
                        break;
                    case "Open Grade File":
                        loadGrades();
                        break;
                    case "Open Attendance File":
                        loadAttendance();
                        break;
                }
            } catch (Exception ex) {
                Log.debug(ex.getMessage());
            }
        }

    }


}
