import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/*
Author: Chandan Yadav
File Version: 1.0
Time required: 6 hours
Description: Observer Class for TableObserver which is used to retrieve data 
and post it on the table upon any change in the student class
Output: Table with the list of entries
*/

public class Table75Observer extends JPanel implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		this.removeAll();
        Iterator71 iterator = ((StudentRepository71)o).getIterator();
		ArrayList<String> column_Names = new ArrayList<>();
		column_Names.add("ID");
		column_Names.add("First Name");
		column_Names.add("Last Name");
		column_Names.add("Program and Plan");
		column_Names.add("Academic Level");
		column_Names.add("ASURITE");

		while(iterator.hasNext())
		{
			Student71 obj = (Student71) iterator.next();
			LinkedList<Grades72> grades_List= obj.getGrades();
			
		if (grades_List.size() > 0) {
			for (Grades72 gList : grades_List) {
				if (!column_Names.contains(gList.quizName)) {
					column_Names.add(gList.quizName);
				}
			}
		}

		LinkedList<Attendance72> attendance_List = obj.getAttendanceList();
		if (attendance_List.size() > 0) {
			for (Attendance72 attList : attendance_List) {
				if (!column_Names.contains(attList.date)) {
					column_Names.add(attList.date);
				}
			}
		}
		}
		
		iterator = ((StudentRepository71)o).getIterator();
		
		String[] columns = new String[column_Names.size()];
		int i = 0;
		for (String col : column_Names) {
			columns[i++] = col;
		}

		ArrayList<ArrayList<String>> data_entry = new ArrayList<>();
		data_entry = findData(iterator);
		String data_List[][] = new String[data_entry.size()][columns.length];
		for (i = 0; i < data_entry.size(); i++) {
			for (int j = 0; j < data_entry.get(i).size(); j++) {
				data_List[i][j] = data_entry.get(i).get(j);
			}
		}

		// JTable with list of column names and data_List
		JTable j_table = new JTable();
		DefaultTableModel model = new DefaultTableModel(data_List, columns);
		j_table.setModel(model);
		this.add(new JScrollPane(j_table));
		SwingUtilities.updateComponentTreeUI(this);
        
	}

	public static ArrayList<ArrayList<String>> findData(Iterator71 iterator) {
		ArrayList<ArrayList<String>> data_List = new ArrayList<>();
		while (iterator.hasNext()) {
			Student71 studentDetails = (Student71) iterator.next();
			ArrayList<String> student = new ArrayList<>();
			student.add(studentDetails.getId());
			student.add(studentDetails.getFirst_name());
			student.add(studentDetails.getLast_name());
			student.add(studentDetails.getProgramPlan());
			student.add(studentDetails.getAcademic_level());
			student.add(studentDetails.getAsurite());

			LinkedList<Grades72> grades_List= studentDetails.getGrades();
			
			if (grades_List.size() > 0) {
				for (Grades72 gList : grades_List) {
					student.add(String.valueOf(gList.result));
				}
			}

			LinkedList<Attendance72> attendance_List =studentDetails.getAttendanceList();
			if (attendance_List.size() > 0) {
				for (Attendance72 attList : attendance_List) {
					student.add(String.valueOf(attList.minutes));
				}
			}
			data_List.add(student);
		}
		return data_List;
	}
}
