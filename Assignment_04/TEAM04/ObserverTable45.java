import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.*;

/**
 * Class: ObserverTable45
 * Responsibility: Observe the StudentRepository41 and update the JTable accordingly
 *
 * @author Nitin
 */
public class ObserverTable45 extends JPanel implements Observer {

    /**
     * Function: Updates the JTable
     */
    @Override
    public void update(Observable o, Object arg) {

        // Initialize with no data in the JPanel
        this.removeAll();

        // Get the column names using the observable
        String[] colName = getColumnNames(o);

        // Get the students data
        Object[][] data = getStudentsData(o, colName);

        // Create the JTable
        JTable table = new JTable();
        table.setModel(new DefaultTableModel(data, colName));
        JScrollPane scrollPane = new JScrollPane(table);
        this.add(scrollPane);
        SwingUtilities.updateComponentTreeUI(this);
    }

    /**
     * Function: Returns a list of column names to be used in JTable
     */
    private String[] getColumnNames(Observable o) {

        // Initialize the list with some columns
        List<String> columnName = new ArrayList<>();
        columnName.add("Student ID");
        columnName.add("ASURITE ID");
        columnName.add("First Name");
        columnName.add("Last Name");
        columnName.add("Academic Level");
        columnName.add("Program and Plan");

        // Add columns for the grades
        Iterator iterator = ((Repository41) o).getIterator();
        StudentCoreData42 student = (StudentCoreData42) iterator.next();
        if (student.getGradesList() != null) {
            for (GradesModel42 g : student.getGradesList()) {
                columnName.add(g.getAssignmentName());
            }
        }

        // Add columns for the attendance
        if (student.getAttendanceList() != null) {
            for (AttendanceModel42 a : student.getAttendanceList()) {
                columnName.add(a.getDate());
            }
        }

        // Convert list into an array
        String[] colName = new String[columnName.size()];
        int index = 0;
        for (String column : columnName) {
            colName[index] = column;
            index += 1;
        }
        return colName;
    }

    /**
     * Function: Converts the data from student repository into 2D array of objects
     */
    private Object[][] getStudentsData(Observable o, String[] colName) {

        // Count the number of students in the repository
        Iterator iterator = ((Repository41) o).getIterator();
        int noOfStudents = 0;
        while (iterator.hasNext()) {
            noOfStudents++;
            iterator.next();
        }

        // Convert student data into a form accepted by JTable
        iterator = ((Repository41) o).getIterator();
        Object[][] data = new Object[noOfStudents][colName.length];
        int i = 0;
        while (iterator.hasNext()) {
            int j = 0;
            StudentCoreData42 student = (StudentCoreData42) iterator.next();
            data[i][j++] = student.getId();
            data[i][j++] = student.getAsurite();
            data[i][j++] = student.getFirstName();
            data[i][j++] = student.getLastName();
            data[i][j++] = student.getAcademicLevel();
            data[i][j++] = student.getProgram();
            if (student.getGradesList() != null) {
                for (GradesModel42 g : student.getGradesList()) {
                    data[i][j++] = g.getMarksObtained();
                }
            }
            if (student.getAttendanceList() != null) {
                for(AttendanceModel42 a: student.getAttendanceList()){
                    data[i][j++] = a.getMinutes();
                }
            }
            i++;
        }
        return data;
    }
}
