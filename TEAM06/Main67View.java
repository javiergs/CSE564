import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * This class is the View of the MVC pattern
 *
 * Since this class inherits from JFrame, it acts as the GUI and it is decorated
 * with GUI elements such as ObserverTable and ObserverPlotter.
 *
 * @author Amit Maharana (amahara1)
 * @since 10/23/2020
 */

public class Main67View extends JFrame {

	private ObserverTable65 table;
	private ObserverPlotter66 plotter;

	private JButton buttonAttendance;
	private JButton buttonGrades;
	private JButton buttonRoster;

	public Main67View(ObserverTable65 table, ObserverPlotter66 plotter) {
		this.table = table;
		this.plotter = plotter;
		init();
	}

	/**
	 * Initialize the View
	 */
	private void init() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		setTitle(Main67Constants.WINDOW_TITLE);
		setSize(screenSize.width, screenSize.height);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);

		decorateUI();

		setVisible(true);
	}

	/**
	 * Helper to add GUI elements
	 */
	private void decorateUI() {
		buttonAttendance = new JButton(Main67Constants.LABEL_ATTENDANCE);
		buttonAttendance.setEnabled(false);

		buttonGrades = new JButton(Main67Constants.LABEL_GRADES);
		buttonGrades.setEnabled(false);

		buttonRoster = new JButton(Main67Constants.LABEL_ROSTER);

		JPanel top = new JPanel(new FlowLayout());
		top.setBackground(new Color(128, 128, 128));

		top.add(buttonRoster);
		top.add(buttonGrades);
		top.add(buttonAttendance);

		JPanel center = new JPanel(new FlowLayout());
		center.setBackground(new Color(211, 211, 211));

		center.add(table);

		JPanel bottom = new JPanel(new FlowLayout());
		bottom.setBackground(new Color(128, 128, 128));

		bottom.add(plotter);

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());

		mainPanel.add(top, BorderLayout.NORTH);
		mainPanel.add(center, BorderLayout.CENTER);
		mainPanel.add(bottom, BorderLayout.SOUTH);

		add(mainPanel, BorderLayout.CENTER);
	}

	public JButton getButtonAttendance() {
		return buttonAttendance;
	}

	public JButton getButtonGrades() {
		return buttonGrades;
	}

	public JButton getButtonRoster() {
		return buttonRoster;
	}
}
