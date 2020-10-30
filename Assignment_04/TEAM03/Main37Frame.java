package src;

import javax.swing.*;
import java.awt.*;
/**
 * Main37Frame is the file that handles the UI for the application
 *
 * @author  Sheran Dass
 * @version 1.0
 * @since   2019-10-24, number of hours = 3 hours - 1 1/2hr meeting 1 1/2 hour coding
 */

public class Main37Frame extends JFrame{
    Main37Frame(String title, ObserverPlotter36 observerPlotter, ObserverTable35 observerTable, Main37RosterButtonListener rosterListener, Main37GraderButtonListener graderListener, Main37ReporterButtonListener reporterListener){
        super(title);
        int frameWidth;
        int frameHeight;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frameWidth = screenSize.width;
        frameHeight = screenSize.height;

        JButton buttonRoster = new JButton();
        buttonRoster.setText("Open Roster");
        buttonRoster.setBounds(0,0,100,50);
        buttonRoster.addActionListener(rosterListener);

        JButton buttonReporter = new JButton();
        buttonReporter.setText("Open Attendance");
        buttonReporter.setBounds(110,0,100,50);
        buttonReporter.addActionListener(reporterListener);

        JButton buttonGrader = new JButton();
        buttonGrader.setText("Open Grades");
        buttonGrader.setBounds(220,0,100,50);
        buttonGrader.addActionListener(graderListener);

        JPanel top = new JPanel(new FlowLayout());
        top.setBackground(new Color(100,200,250));
        top.setPreferredSize(new Dimension(800,100));
        top.add(buttonRoster);
        top.add(buttonReporter);
        top.add(buttonGrader);

        JPanel center = observerTable.getPanel();
        center.setBackground(new Color(250,200,200));
        center.setPreferredSize(new Dimension(800,350));

        JPanel bottom = observerPlotter.getPanel();
        bottom.setBackground(new Color(150,250,250));
        bottom.setPreferredSize(new Dimension(800,350));

        setLayout(new BorderLayout());
        add(top, BorderLayout.NORTH);
        add(center, BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);
        setMinimumSize(new Dimension(frameWidth, (int) (frameHeight/1.1)));
        setPreferredSize(new Dimension(frameWidth, frameHeight));
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }


}
