import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * This class is the Controller of the MVC pattern. Control is transferred over
 * to the SWING framework.
 *
 * @author Amit Maharana (amahara1)
 * @since 10/23/2020
 */

public class Main67Controller {

	private Repository61 model;
	private Main67View view;
	private Grader63 grader;
	private Reporter64Decorator reporter;

	public Main67Controller(Repository61 model, Main67View view) {
		this.model = model;
		this.view = view;
		grader = new Grader63();
		reporter = new Reporter64Decorator(new Reporter64Data());
		init();
	}

	/**
	 * Initialize the Controller
	 */
	private void init() {
		view.getButtonAttendance().addActionListener(e -> attendanceSelected());
		view.getButtonGrades().addActionListener(e -> gradesSelected());
		view.getButtonRoster().addActionListener(e -> rosterSelected());
	}

	/**
	 * Action listener for roster button
	 */
	private void rosterSelected() {
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(Main67Constants.FILE_TYPE,
				Main67Constants.FILE_EXTENSION);
		fileChooser.setFileFilter(filter);
		int result = fileChooser.showOpenDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			model.readFile(fileChooser.getSelectedFile().getAbsolutePath());
			view.getButtonGrades().setEnabled(true);
		}
	}

	/**
	 * Action listener for grades button
	 */
	private void gradesSelected() {
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(Main67Constants.FILE_TYPE,
				Main67Constants.FILE_EXTENSION);
		fileChooser.setFileFilter(filter);
		int result = fileChooser.showOpenDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			grader.decorateRepositoryWithGrades(fileChooser.getSelectedFile().getAbsolutePath());
			view.getButtonAttendance().setEnabled(true);
		}
	}

	/**
	 * Action listener for attendance button
	 */
	private void attendanceSelected() {
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(Main67Constants.FILE_TYPE,
				Main67Constants.FILE_EXTENSION);
		fileChooser.setFileFilter(filter);
		int result = fileChooser.showOpenDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			reporter.decorateStudentsWithAttendance(fileChooser.getSelectedFile().getAbsolutePath());
		}
	}
}
