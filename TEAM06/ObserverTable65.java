import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import java.util.*;

/**
 * This class is an Observer of a StudentRepository61 object. Calling update
 * will generate an updated table model for the repository based on its
 * contents.
 *
 * Since this class inherits from JPanel, simply call the default constructor
 * and add the resulting ObserverTable object to the parent component. You must
 * attach this object as an observer to the observable StudentRepository61
 * object, and upon calling 'notifyObservers()' will update the table
 * accordingly.
 *
 * Hours Spent: 2 (implementation) + 2 (refactoring and working with team)
 *
 * @author Tanner Lisonbee (tblisonb)
 * @since 10/24/2020
 */
public class ObserverTable65 extends JPanel implements Observer {

	private JTable table;
	private List<String> headerFields;

	/**
	 * Sets up the ObserverTable object with its nested components.
	 *
	 * @param tableWidth  Width of the created table
	 * @param tableHeight Height of the created table
	 */
	public ObserverTable65(int tableWidth, int tableHeight) {
		this.setPreferredSize(new Dimension(tableWidth, tableHeight));
		this.setLayout(new BorderLayout());
		this.headerFields = new LinkedList<>();
		initTable();
	}

	/**
	 * Updates the table contents provided the observable StudentRepository61
	 * object.
	 *
	 * @param o   Expects a StudentRepository61 object
	 * @param arg Not used; can be set to null
	 */
	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof Repository61) {
			List<String> headers = updateHeaders((Repository61) o);
			updateData((Repository61) o, headers);
			// update the nested components within this panel
			SwingUtilities.updateComponentTreeUI(this);
		}
	}

	/**
	 * Private helper for setting up the table headers based on the contents of the
	 * repository.
	 *
	 * @param repository Observable StudentRepository61 object
	 * @return A list of all the headers for the table as Strings
	 */
	private List<String> updateHeaders(Repository61 repository) {
		// Iterate through repository, adding grades and attendance for each student
		for (Iterator iter = repository.getIterator(); iter.hasNext();) {
			Decorator62StudentInterface student = (Decorator62StudentInterface) iter.next();
			// add grades
			if (student != null && student.getGrades() != null)
				for (Decorator62GradeBean grade : student.getGrades()) {
					if (!headerFields.contains(grade.getAssesmentName()))
						headerFields.add(grade.getAssesmentName());
				}
			// add attendance
			if (student != null && student.getAllAttendance() != null)
				for (Decorator62AttendanceBean attendance : student.getAllAttendance()) {
					if (!headerFields.contains(attendance.getDate()))
						headerFields.add(attendance.getDate());
				}
		}
		return headerFields;
	}

	/**
	 * Private helper for setting up the table contents based on the contents of the
	 * repository.
	 *
	 * @param repository   Observable StudentRepository61 object
	 * @param headerFields All the header fields needed for the data to be populated
	 *                     in the table
	 */
	private void updateData(Repository61 repository, List<String> headerFields) {
		List<List<Object>> data = new LinkedList();
		// Iterate through all the Student62 objects in the repository
		for (Iterator iter = repository.getIterator(); iter.hasNext();) {
			Decorator62StudentInterface student = (Decorator62StudentInterface) iter.next();
			if (student != null) {
				List<Object> studentData = extractStudent62Data(student);
				data.add(studentData);
			}
		}
		// Convert the nested list of table elements to a 2D array to be passed to the
		// table model
		Object[][] dataArray = new Object[data.size()][getMaxRowWidth(data)];
		for (int i = 0; i < data.size(); i++) {
			for (int j = 0; j < data.get(i).size(); j++) {
				dataArray[i][j] = data.get(i).get(j);
			}
		}
		// update model
		table.setModel(new DefaultTableModel(dataArray, headerFields.toArray()));
	}

	/**
	 * Private helper for getting the maximum number of columns for the table based
	 * on the Student62 objects contained in StudentRepository61.
	 *
	 * @param studentData Nested list of Student6262 objects and each student's
	 *                    elements (e.g. ID, ASURITE, name, etc.)
	 * @return Integer value of the maximum size of all these elements
	 */
	private int getMaxRowWidth(List<List<Object>> studentData) {
		int resultMax = 0;
		for (List<Object> student : studentData) {
			if (resultMax < student.size()) {
				resultMax = student.size();
			}
		}
		return resultMax;
	}

	/**
	 * Private helper for getting all the relevant data fields from a Student62
	 * object, including its core data, as well as grades and attendance to be
	 * populated within the corresponding row in the table.
	 *
	 * @param student Student62 object to be searched
	 * @return List of Objects corresponding to the fields contained in Student62
	 */
	private List<Object> extractStudent62Data(Decorator62StudentInterface student) {
		List<Object> studentData = new ArrayList<>();
		for (int i = 0; i < 6 + headerFields.size(); i++)
			studentData.add(null);
		// add core data
		studentData.set(0, student.getId());
		studentData.set(1, student.getFirstName());
		studentData.set(2, student.getLastName());
		studentData.set(3, student.getProgramAndPlan());
		studentData.set(4, student.getAcademicLevel());
		studentData.set(5, student.getAsurite());
		// add grades
		if (student.getGrades() != null)
			for (Decorator62GradeBean grade : student.getGrades()) {
				if (headerFields.contains(grade.getAssesmentName())) {
					studentData.set(headerFields.indexOf(grade.getAssesmentName()), grade.getScore());
				}
			}
		// add attendance
		if (student.getAllAttendance() != null)
			for (Decorator62AttendanceBean attendance : student.getAllAttendance()) {
				if (headerFields.contains(attendance.getDate())) {
					studentData.set(headerFields.indexOf(attendance.getDate()), attendance.getMinutes());
				}
			}
		return studentData;
	}

	/**
	 * Adds the table to a JScrollPane containing the JTable instance to the parent
	 * JPanel. Also adds the required core fields that each Student62 is guaranteed
	 * to have.
	 */
	private void initTable() {
		// Add core headers
		headerFields.add("ID");
		headerFields.add("First Name");
		headerFields.add("Last Name");
		headerFields.add("Program and Plan");
		headerFields.add("Academic Level");
		headerFields.add("ASURITE");
		table = new JTable();
		for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
			table.getColumnModel().getColumn(i).setWidth(75);
		}
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		JScrollPane tableContainer = new JScrollPane(table);
		this.add(tableContainer, BorderLayout.CENTER);
	}

}
