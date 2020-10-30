import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * ObserverTable95.java - Observer Class for gathering values and updating Table
 *
 * @author Ashwin Srinivasan
 */
public class ObserverTable95 extends JPanel implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        this.removeAll();
        Iterator iterator = ((Student91Observable)o).getIterator();
        Student92Model student = (Student92Model) iterator.next();
        List<String> headers = new ArrayList<>();
        headers.add("ID");
        headers.add("First Name");
        headers.add("Last Name");
        headers.add("Program and Plan");
        headers.add("Academic Level");
        headers.add("ASURITE");
        if(student.decorators.containsKey("Grade")){
            java.util.List<Grade92Model> lst = (java.util.List<Grade92Model>)student.decorators.get("Grade");
            for(Grade92Model g: lst){
                if(!headers.contains(g.colName)){
                    headers.add(g.colName);
                }
            }
        }
        if(student.decorators.containsKey("Attendance")){
            java.util.List<Attendance92Model> lst =
                    (java.util.List<Attendance92Model>)student.decorators.get("Attendance");
            for(Attendance92Model a: lst){
                if(!headers.contains(a)){
                    headers.add(a.date);
                }
            }
        }
        String headerArray[]=  new String[headers.size()];
        int index =0;
        for(String header:headers){
            headerArray[index] = header;
            index += 1;
        }
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        iterator = ((Student91Observable)o).getIterator();
        data = getData(iterator);
        String dataArray[][] = new String[data.size()][headerArray.length];
        for(int i=0;i<data.size(); i++){
            for(int j=0;j<data.get(i).size();j++){
                dataArray[i][j] = data.get(i).get(j);
            }
        }
        JTable table = new JTable();
        table.setModel(new DefaultTableModel(dataArray, headerArray));
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        this.add(new JScrollPane(table));
        this.setPreferredSize(new Dimension(2400,1000));
        SwingUtilities.updateComponentTreeUI(this);
    }

    public static ArrayList<ArrayList<String>> getData(Iterator studentRepository){
        ArrayList<ArrayList<String>> studentData = new ArrayList<>();
        while(studentRepository.hasNext()){
            Student92Model student = (Student92Model) studentRepository.next();
            ArrayList<String> individualStudent = new ArrayList<>();
            individualStudent.add(student.getStudentID());
            individualStudent.add(student.getFirstName());
            individualStudent.add(student.getLastName());
            individualStudent.add(student.getStudentProgram());
            individualStudent.add(student.getStudentAcademicLevel());
            individualStudent.add(student.getStudentAsurite());
            if(student.decorators.containsKey("Grade")){
                java.util.List<Grade92Model> lst = (java.util.List<Grade92Model>)student.decorators.get("Grade");
                for(Grade92Model g: lst){
                    individualStudent.add(g.score);
                }
            }
            if(student.decorators.containsKey("Attendance")){
                java.util.List<Attendance92Model> lst =
                        (java.util.List<Attendance92Model>)student.decorators.get("Attendance");
                for(Attendance92Model a: lst){
                    individualStudent.add(a.minutes);
                }
            }
            studentData.add(individualStudent);
        }
        return studentData;
    }
}
