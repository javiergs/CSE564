import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.*;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 * Observer Pattern Table Panel Class CSE 564 - Assignment 4 Team 8 - Member 5
 * (ID 85) Jayant Raj (jraj2) 25 Oct. 2020 Total Time invested --> 4hrs(research
 * and dev) | 6hrs (Integration)
 */

@SuppressWarnings("deprecation")
public class ObserverTable85 extends JPanel implements Observer {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Override
    public void update(Observable o, Object arg) {
        this.removeAll();
        Repository81Iterator student_iterator = ((Repository81StudentRepository) o).getIterator();

        Decorator82StudentInterface student_details = (Decorator82StudentInterface) student_iterator.next();

        List<String> col_name = new ArrayList<>();
        col_name.add("ID");
        col_name.add("First Name");
        col_name.add("Last Name");
        col_name.add("Program and Plan");
        col_name.add("Academic Level");
        col_name.add("ASURITE");

        if (student_details.decorations.containsKey("Grades")) {
            List<Grader83Grade> lst = (List<Grader83Grade>) student_details.decorations.get("Grades");
            for (Grader83Grade g : lst) {
                if (!col_name.contains(g.getName())) {
                    col_name.add(g.getName());
                }
            }
        }
        if (student_details.decorations.containsKey("Attendance")) {
            List<Reporter84Attendance> lst = (List<Reporter84Attendance>) student_details.decorations.get("Attendance");
            for (Reporter84Attendance a : lst) {
                if (!col_name.contains(a)) {
                    col_name.add(a.getDate());
                }
            }
        }
        String col_array[] = new String[col_name.size()];
        int index = 0;
        for (String col : col_name) {
            col_array[index] = col;
            index += 1;
        }

        ArrayList<ArrayList<String>> data = new ArrayList<>();
        student_iterator = ((Repository81StudentRepository) o).getIterator();
        data = getData(student_iterator);
        String temp[][] = new String[data.size()][col_array.length];
        for (int i = 0; i < data.size(); i++) {
            for (int j = 0; j < data.get(i).size(); j++) {
                temp[i][j] = data.get(i).get(j);
            }
        }
        JTable table = new JTable();
        table.setModel(new DefaultTableModel(temp, col_array));
        this.add(new JScrollPane(table));
        SwingUtilities.updateComponentTreeUI(this);
        this.repaint();
    }

    public static ArrayList<ArrayList<String>> getData(Repository81Iterator student_iterator) {
        ArrayList<ArrayList<String>> studentData = new ArrayList<>();
        while (student_iterator.hasNext()) {
            Decorator82StudentInterface student_details = (Decorator82StudentInterface) student_iterator.next();
            ArrayList<String> student = new ArrayList<>();
            student.add(student_details.getIdentificationNum());
            student.add(student_details.getFirstName());
            student.add(student_details.getLastName());
            student.add(student_details.getProgramAndPlan());
            student.add(student_details.getAcademicLevel());
            student.add(student_details.getAsurite());
            if (student_details.decorations.containsKey("Grades")) {
                List<Grader83Grade> lst = (List<Grader83Grade>) student_details.decorations.get("Grades");
                for (Grader83Grade g : lst) {
                    student.add(String.valueOf(g.getScore()));
                }
            }
            if (student_details.decorations.containsKey("Attendance")) {
                List<Reporter84Attendance> lst = (List<Reporter84Attendance>) student_details.decorations
                        .get("Attendance");
                for (Reporter84Attendance a : lst) {
                    student.add(a.getMin());
                }
            }
            studentData.add(student);
        }
        return studentData;
    }

}
