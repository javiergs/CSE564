package team1;

import team1.isaac.ObserverTable15;
import team1.kings.ObserverPlotter16;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Main17UI class is JFrame and responsible for creating User Interface
 *
 * @author Shwetank Bhardwaj
 * @version 1.0
 * @since 10-25-2020
 */

public class Main17UI extends JFrame{

    private JButton repoButton;
    private JButton gradeButton;
    private JButton attendanceButton;
    private final ObserverTable15 observerTable15;
    private final ObserverPlotter16 observerPlotter16;

    public Main17UI(ObserverTable15 observerTable15, ObserverPlotter16 observerPlotter16) {
        this.observerTable15 = observerTable15;
        this.observerPlotter16 = observerPlotter16;
    }

    public void createUI(){
        setTitle("Team 1 Project");
        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel menuPanel = getMenuPanel();
        mainPanel.add(menuPanel, BorderLayout.NORTH);

        JPanel innerPanel = new JPanel(new BorderLayout());
        innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.Y_AXIS));

        innerPanel.add(observerTable15);
        innerPanel.add(observerPlotter16);

        mainPanel.add(innerPanel);
        add(mainPanel);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JPanel getMenuPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        addActionButtons(panel);
        return panel;
    }

    private void addActionButtons(JPanel panel) {
        repoButton = new JButton("Open Student File");
        gradeButton = new JButton("Open Grade File");
        attendanceButton =  new JButton("Open Attendance File");
        panel.add(repoButton);
        panel.add(gradeButton);
        panel.add(attendanceButton);
    }

    public void addRepoClickListener(ActionListener repoButtonClicked) {
        repoButton.addActionListener(repoButtonClicked);
    }

    public void addGradeClickListener(ActionListener gradeButtonClicked) {
        gradeButton.addActionListener(gradeButtonClicked);
    }

    public void addAttendanceClickListener(ActionListener attendanceButtonClicked) {
        attendanceButton.addActionListener(attendanceButtonClicked);
    }

    public String selectFile() {
        JFileChooser mFileChooser = new JFileChooser();
        if (mFileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File f = mFileChooser.getSelectedFile();
            if (f == null) {
                return "";
            }
            return f.toString();
        }
        return "";
    }

}
