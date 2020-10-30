import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * @author srinivasan
 * @since 10/25/2020
 * Main class to create buttons and populate the View Frame
 */
public class Main97 extends JFrame {

    private final Main97Controller controller;
    private final JButton openRoster;
    private final JButton openGrades;
    private final JButton openAttendance;
    private final JPanel topPanel;

    Main97(){
        controller = new Main97Controller(this);
        openRoster = new JButton("Open Roster");
        openGrades = new JButton("Open Grades");
        openAttendance = new JButton("Open Attendance");
        topPanel = new JPanel();
    }

    public void createView(){
        openRoster.addActionListener(e -> controller.rosterController());
        openGrades.addActionListener(e -> controller.gradeController());
        openAttendance.addActionListener(e -> controller.attendanceController());
        topPanel.add(openRoster);
        topPanel.add(openGrades);
        topPanel.add(openAttendance);
        add(topPanel, BorderLayout.NORTH);
        setExtendedState(getExtendedState() | MAXIMIZED_BOTH);
        setVisible(true);
    }

    public static void main(String[] args) {
        Main97 main = new Main97();
        main.createView();
    }
}
