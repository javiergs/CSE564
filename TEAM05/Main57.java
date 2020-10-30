import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Main Class - Starting point of execution 
 * Time Required - 3 hours
 * 
 * @author mkataruk
 *
 */
public class Main57 extends JFrame {

	private static final long serialVersionUID = -2420153033212492371L;
	private static final String TITLE = "Software Design Assignment-4 Team 5";
	private static final String BUTTON_NAME_STUDENT_ROSTER = "Load Student Data";
	private static final String BUTTON_NAME_STUDENT_GRADE = "Load Student Grades";
	private static final String BUTTON_NAME_STUDENT_ATTENDANCE = "Load Student Attendance";

	public Main57() {
		Rectangle screenSize = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
		setLayout(null);
		setTitle(TITLE);
		setBackground(Color.BLACK);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(0, 0, screenSize.width, screenSize.height);
	}

	private JButton[] createLoadButtons() {
		JButton loadStudent = new JButton(BUTTON_NAME_STUDENT_ROSTER);
		loadStudent.setBounds(20, 20, 200, 50);
		JButton loadGrades = new JButton(BUTTON_NAME_STUDENT_GRADE);
		loadGrades.setBounds(250, 20, 200, 50);
		JButton loadAttendance = new JButton(BUTTON_NAME_STUDENT_ATTENDANCE);
		loadAttendance.setBounds(500, 20, 200, 50);
		this.add(loadStudent);
		this.add(loadGrades);
		this.add(loadAttendance);
		return new JButton[] { loadStudent, loadGrades, loadAttendance };
	}

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Main57 main = new Main57();
		ObserverTable55 tablePanel = new ObserverTable55();
		main.add(tablePanel);
		ObserverPlotter56 plotterPanel = new ObserverPlotter56();
		main.add(plotterPanel);
		StudentRepository51 studentRepository = new StudentRepository51();
		studentRepository.addObserver(tablePanel);
		studentRepository.addObserver(plotterPanel);
		LoadGrades53 grade = new LoadGrades53(studentRepository);
		LoadAttendance54 attendance = new LoadAttendance54(studentRepository);
		LoadStudents51 loadStudents = new LoadStudents51(studentRepository);
		JButton buttons[] = main.createLoadButtons();
		MainController57 controller = new MainController57(buttons, loadStudents, grade, attendance);
		controller.addButtonListener();
		main.setVisible(true);
	}
}
