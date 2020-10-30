/**
 * MainController107 Controller of Main(View)
 * Time taken to implement ~ 2 hours.
 *
 * @author Xinkai Wang
 * @version 1.1
 * @since 10-27-2020
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main107Controller {
	JFileChooser jfilechooser = new JFileChooser("."); 
	String rosterPath;
	String gradePath;
	String attendancePath;
	CourseGrader103 grader;
	Reporter104 reporter;
	Repository101StudentRepository repo;
	
	public Main107Controller(Main107 main) {
		this.grader = CourseGrader103.getInstance();
		this.reporter = new Reporter104();
		this.repo = new Repository101StudentRepository(); 
		this.repo.addObserver(main.observerTable);
	}
	
	public ActionListener Get_Btn_Roster_Listener(JLabel label_roster) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int a = jfilechooser.showOpenDialog(null); 
				if(a == JFileChooser.APPROVE_OPTION){
					rosterPath = jfilechooser.getSelectedFile().getPath();
					label_roster.setText(rosterPath);
				}
			}
		};
	}
	
	public ActionListener Get_Btn_Grade_Listener(JLabel label_grade) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int a = jfilechooser.showOpenDialog(null); 
				if(a == JFileChooser.APPROVE_OPTION){
					gradePath = jfilechooser.getSelectedFile().getPath();
					label_grade.setText(gradePath);
				}
			}
		};
	}
	
	public ActionListener Get_Btn_Attendance_Listener(JLabel label_attendance) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = jfilechooser.showOpenDialog(null); 
				if(a == JFileChooser.APPROVE_OPTION){
					attendancePath = jfilechooser.getSelectedFile().getPath();
					label_attendance.setText(attendancePath);
				}
			}
		};
	}
	
	public ActionListener Get_Btn_Update_Listener(JLabel label_warning) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update(label_warning);
			}
		};
	}
	
	private void update(JLabel label_warning) {
		if(rosterPath == null || gradePath == null || attendancePath == null) {
			label_warning.setText("File Missing!");
			return;
		}
		label_warning.setText("");

		repo.createStudentObjectsFromFile(rosterPath);
		try {
			grader.setFilePath(gradePath);
			grader.processGrades(repo);
			reporter.decorate(repo, attendancePath);
		} catch(Exception ex) {
			
		}
	}
	
}
