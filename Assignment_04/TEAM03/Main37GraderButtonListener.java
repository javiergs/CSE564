package src;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Main37GradeButtonListener is the file that handles the Grader's UI controller for the application
 *
 * @author  Sheran Dass
 * @version 1.0
 * @since   2019-10-24, number of hours = 3 hours - 1 1/2hr meeting 1 1/2 hour coding
 */

public class Main37GraderButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Repository31 studentRepository31 = Repository31.getInstance();
        JFileChooser fileChooser = new JFileChooser();
        int r = fileChooser.showOpenDialog(null);

        if (r == JFileChooser.APPROVE_OPTION) {
            String fileGrader = fileChooser.getSelectedFile().getAbsolutePath();
            Repository31Visitor visitor = null;
            try {
                visitor = new Grader33(fileGrader);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            studentRepository31.accept(visitor);
        }
    }
}
