// Time taken : 1.5 hours
// Author : Ankit Vutukuri

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class ObserverTable105 extends JPanel implements Observer{
    public String[][] data;
    public String[] columnNames;
    JTable studentTable;

    public ObserverTable105() {
        studentTable = new JTable();
        JScrollPane sp = new JScrollPane(studentTable);
        this.add(sp);
        columnNames = new String[]{"ASU ID", "Student Info", "Grades", "Attendance"};
    }

	@Override
	public void update(Observable o, Object arg) {
		
		int dataCounter1 = 0;
        Repository101StudentRepository repository101StudentRepository = (Repository101StudentRepository) o;
        data = new String[repository101StudentRepository.students.size()][4];
        Repository101Iterator iterator = repository101StudentRepository.getIterator();

        while (iterator.hasNext()) {
            int dataCounter2 = 0;
            Decorator102Student student = (Decorator102Student) iterator.next();
            String[] info = student.getInfo().split(";");
            data[dataCounter1][dataCounter2++] = info[1];
            data[dataCounter1][dataCounter2++] = info[0];
            for (int i = 2; i < info.length; i++) {
                data[dataCounter1][dataCounter2++] = info[i];
            }

            dataCounter1++;
        }

        studentTable.setModel(new DefaultTableModel(data, columnNames));
	}

}
