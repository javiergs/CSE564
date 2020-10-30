// Created by: Vraj Kapadia
// Asurite: vrkapadi
// ASU Id: 1217192587
// Time taken: 2 hours

import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

public class ObserverTable55 extends JPanel implements Observer{

    private JTable table;
    private JScrollPane scrollPane;
    private Rectangle screenSize = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
    private String data[][];
    private String[] newCol;

    public ObserverTable55() {
        setBorder(BorderFactory.createLineBorder(Color.black));
        setBounds(20, 80, screenSize.width / 2 - 10, screenSize.height - screenSize.height / 7);
    }
    @Override
    public void update(Observable o, Object arg) {
        List<String> column;
        Set<String> col = new LinkedHashSet<>();
        column = Arrays.asList(new String[]{"NAME", "Program", "Level", "Asurite"});
        List<List<String>> list = new ArrayList<>();
        for (StudentIterator51 iter = ((StudentRepository51)o).getIterator(); iter.hasNext(); ) {
            Student52 student = (Student52) iter.next();
            List<Grade53> gradeList = student.getGrades();
            List<Attendance54> attendanceList = student.getAttendance();
            List<String> studentDetails = new ArrayList<>();
            studentDetails.add(student.getName());
            studentDetails.add(student.getProgram());
            studentDetails.add(student.getLevel());
            studentDetails.add(student.getAsurite());
            if (gradeList!=null) {
                for (Grade53 grade : gradeList) {
                    col.add(grade.getTitle());
                    studentDetails.add(grade.getPercentageObtained());
                }
            }
            if (attendanceList!=null) {
                for (Attendance54 attendance : attendanceList) {
                    col.add(attendance.getDate());
                    studentDetails.add(attendance.getMinutes());
                }
            }
            list.add(studentDetails);
        }
        data = new String[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            List<String> row = list.get(i);
            data[i] = row.toArray(new String[row.size()]);
        }

        newCol = new String[column.size() + col.size()];
        int i = 0;
        for(String s: column) {
            newCol[i++] = s;
        }
        for(String s: col) {
            newCol[i++] = s;
        }
        this.repaint();
    }

    protected void paintComponent(Graphics g) {
        this.removeAll();
        if (data!=null) {
            table = new JTable(data, newCol);
            table.setVisible(true);
            scrollPane = new JScrollPane(table);
            scrollPane.setBounds(0, 0, screenSize.width/2 - 20, screenSize.height - screenSize.height/7);
            scrollPane.setVisible(true);
            this.add(scrollPane);
        }
    }
}
