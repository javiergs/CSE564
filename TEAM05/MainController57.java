import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;

/**
 * Controller for Main, mainly adds action listener to buttons
 * 
 * @author mkataruk
 *
 */
public class MainController57 {

	private JButton[] buttons;
	private LoadStudents51 loadStudents;
	private LoadGrades53 grade;
	private LoadAttendance54 attendance;

	public MainController57(JButton[] buttons, LoadStudents51 loadStudents, LoadGrades53 grade,
			LoadAttendance54 attendance) {
		this.buttons = buttons;
		this.loadStudents = loadStudents;
		this.grade = grade;
		this.attendance = attendance;
	}

	private String chooseFile() {
		String fileName = "";
		try {
			JFileChooser chosenFile = new JFileChooser();
			int showOpenDialog = chosenFile.showOpenDialog(null);
			if (showOpenDialog == JFileChooser.APPROVE_OPTION) {
				fileName = chosenFile.getSelectedFile().getAbsolutePath();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileName;
	}

	public void addButtonListener() {
		buttons[0].addActionListener(e -> {
			loadStudents.readRosterCSV(chooseFile());
		});
		buttons[1].addActionListener(e -> {
			try {
				grade.gradeStudents(chooseFile());
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		});
		buttons[2].addActionListener(e -> {
			try {
				attendance.loadStudentAttendance(chooseFile());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});

	}
}
