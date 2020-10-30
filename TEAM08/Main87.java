import javax.swing.*;
import java.awt.*;
import java.io.IOException;
/**
 * <h1>Main87</h1>
 * The Main87 class is the class responsible for the view part
 * of the application and all connecting all the components required.
 * <p>
 * CSE564 - Assignment 4
 * Team 8 - Member 7 (ID 87)
 * Integration time: 6 + 2 hours
 *
 * @author Prakhar Sambhar (psambhar)
 * @since 10-26-2020
 */

public class Main87 extends JFrame {
    Main87(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(screenSize);
        setDefaultLookAndFeelDecorated(true);
        setVisible(true);
    }

    public static void main(String[] args) throws IOException {
        Main87 main = new Main87();
        JButton openGrades = new JButton("Open Grades");
        JButton openAttendance = new JButton("Open Attendance");
        JButton openRoster = new JButton("Open Roster");
        JPanel panel = new JPanel();
        JPanel buttonPanel = new JPanel();
        JPanel resultPanel = new JPanel();
        JPanel containerPanel = new JPanel();
        JButton[] buttons = new JButton[]{openRoster,openGrades,openAttendance};
        ObserverTable85 observerTable = new ObserverTable85();
        ObserverPlotter86 plotter = new ObserverPlotter86("Grade Plot", "Students", "Grades");
        Main87Controller controller = new Main87Controller(buttons, observerTable, plotter, main);
        panel.setLayout(new BorderLayout());
        buttonPanel.add(openGrades);
        buttonPanel.add(openAttendance);
        buttonPanel.add(openRoster);
        resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.Y_AXIS));
        containerPanel.add(resultPanel);
        resultPanel.add(observerTable);
        resultPanel.add(plotter);
        panel.add(buttonPanel,BorderLayout.NORTH);
        panel.add(containerPanel, BorderLayout.CENTER);
        openGrades.setEnabled(false);
        openAttendance.setEnabled(false);
        openGrades.addActionListener(controller);
        openRoster.addActionListener(controller);
        openAttendance.addActionListener(controller);
        main.add(panel);
        main.add(BorderLayout.CENTER, new JScrollPane(panel));
        main.pack();
    }

}
