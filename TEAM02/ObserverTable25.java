import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import java.util.*;

/**
 * @author Nikitha Chilivery
 * @since 10/24/2020
 */


@SuppressWarnings("serial")
public class ObserverTable25 extends JPanel implements Observer {

    @Override
    public void update(Observable o, Object arg) {

        // Initialize with no data in the JPanel
        this.removeAll();
        this.setMaximumSize(new Dimension(100, 250));

        // Get the column names using the observable
        String colName[] = getColumnNames(o);


        Iterator21 iterator = ((StudentRepository21) o).getIterator();
        int noOfStudents = 0;
        while (iterator.hasNext()) {
            noOfStudents++;
            iterator.next();
        }

        // Convert student data into a form accepted by JTable
        iterator = ((StudentRepository21) o).getIterator();
        Object[][] data = new Object[noOfStudents][colName.length];
        int i = 0;
        while (iterator.hasNext()) {
            int j = 0;
            Decorator22Student student = (Decorator22Student) iterator.next();
            data[i][j++] = student.getId();
            data[i][j++] = student.getFirstName();
            data[i][j++] = student.getLastName();
            data[i][j++] = student.getLevel();
            data[i][j++] = student.getProgram();
            data[i][j++] = student.getAsurite();
            for (Decorator22StudentGrades g : student.getGradesList()) {
                data[i][j++] = g.score;
            }

            for (Decorator22StudentAttendance a : student.getAttendanceList()) {
                data[i][j++] = a.min;
            }

            i++;
        }

        // Create the JTable
        JTable table = new JTable();
        table.setModel(new DefaultTableModel(data, colName));
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        this.add(new JScrollPane(table));
        SwingUtilities.updateComponentTreeUI(this);
    }

    /**
     * Function: Returns a list of column names to be used in JTable
     */
    private String[] getColumnNames(Observable o) {

        // Initialize the list with some columns
        List<String> columnName = new ArrayList<>();
        columnName.add("Student ID");
        columnName.add("First Name");
        columnName.add("Last Name");
        columnName.add("Academic Level");
        columnName.add("Program");
        columnName.add("ASURITE");


        // Add columns for the grades
        Iterator21 iterator = ((StudentRepository21) o).getIterator();

        Decorator22Student student = (Decorator22Student) iterator.next();
        for (Decorator22StudentGrades g : student.getGradesList()) {
            if (!columnName.contains(g.name)) {
                columnName.add(g.name);
            }
        }

        // Add columns for the attendance
        for (Decorator22StudentAttendance a : student.getAttendanceList()) {
            if (!columnName.contains(a.date)) {
                columnName.add(a.date);
            }
        }

        // Convert list into an array
        String colName[] = new String[columnName.size()];
        int index = 0;
        for (String column : columnName) {
            colName[index] = column;
            index += 1;
        }
        return colName;
    }
}
