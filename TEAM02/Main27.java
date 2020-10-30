import java.awt.BorderLayout;

import javax.swing.*;

public class Main27 extends JFrame { 

	private static final long serialVersionUID = 1L;
	private JButton saveDetails;
    private JButton saveGrades;
    private JButton saveAttendance;
    private JButton showResults;
    private Main27Controller main27Controller;
    private JFrame frame;
    private JPanel topPanel;
    
	public Main27(){
		frame = new JFrame();
    	saveDetails = new JButton("Save in Repo");
        saveGrades = new JButton("Save Grades");
        saveAttendance = new JButton("Save Attendance");
        showResults = new JButton("Show Results");
        main27Controller = new Main27Controller(frame);
        topPanel = new JPanel();     
	}
	
	public void createUI() {		   
        topPanel.add(saveDetails);
        topPanel.add(saveGrades);
        topPanel.add(saveAttendance);
        topPanel.add(showResults);
        frame.add(topPanel, BorderLayout.NORTH); 
	}
	
	public void performActions() {
		saveDetails.addActionListener(e -> {main27Controller.details();});
        saveGrades.addActionListener(e -> {main27Controller.grades();});
        saveAttendance.addActionListener(e -> {main27Controller.attendance();});
        showResults.addActionListener(e -> {main27Controller.showResults();});
        frame.setExtendedState(getExtendedState() | MAXIMIZED_BOTH);
        frame.setVisible(true);    
	}
	
	public static void main(String[] args)
	{    	
		Main27 obj = new Main27();
		obj.createUI();
		obj.performActions(); 
		
    }	

}