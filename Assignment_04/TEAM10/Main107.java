/**
 * Main107 Create a GUI and connect the other components.
 * Time taken to implement ~ 2 hours.
 *
 * @author Xinkai Wang
 * @version 1.1
 * @since 10-27-2020
 */

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;

public class Main107 extends JFrame{
	private Main107Controller mainController;
	ObserverTable105 observerTable;  
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main107 window = new Main107();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main107() {
		observerTable = new ObserverTable105();
		mainController = new Main107Controller(this);
		JPanel mainPanel = new JPanel();
		this.setBounds(100, 100, 887, 540);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPanel.setBackground(Color.WHITE);
		mainPanel.setLayout(null);
		this.getContentPane().add(mainPanel, BorderLayout.CENTER); 
		
		JPanel menuPanel = new JPanel();
		menuPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		menuPanel.setBackground(Color.WHITE);
		menuPanel.setBounds(10, 10, 851, 66);
		mainPanel.add(menuPanel);
		menuPanel.setLayout(null);
		
		observerTable.setBackground(Color.WHITE);
		observerTable.setBounds(10, 85, 851, 339);
		mainPanel.add(observerTable, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Roster :");
		lblNewLabel.setBounds(472, 10, 54, 15);
		menuPanel.add(lblNewLabel);
		
		JLabel label_1 = new JLabel("Grade :");
		label_1.setBounds(472, 25, 54, 15);
		menuPanel.add(label_1);
		
		JLabel label_2 = new JLabel("Attendance :");
		label_2.setBounds(472, 40, 72, 15);
		menuPanel.add(label_2);
		
		JLabel label_roster = new JLabel("Please choose roster file");
		label_roster.setForeground(Color.BLUE);
		label_roster.setBounds(554, 10, 287, 15);
		menuPanel.add(label_roster);
		
		JLabel label_attendance = new JLabel("Please choose attendance file");
		label_attendance.setForeground(Color.BLUE);
		label_attendance.setBounds(554, 40, 287, 15);
		menuPanel.add(label_attendance);
		
		JLabel label_grade = new JLabel("Please choose grade file");
		label_grade.setBounds(554, 25, 287, 15);
		menuPanel.add(label_grade);
		label_grade.setForeground(Color.BLUE);

		JButton btn_roster = new JButton("Roster");
		btn_roster.addActionListener(mainController.Get_Btn_Roster_Listener(label_roster));
		btn_roster.setFont(new Font("SimSun", Font.BOLD, 14));
		btn_roster.setBounds(10, 10, 120, 40);
		menuPanel.add(btn_roster);
		
		JButton btn_grade = new JButton("Grade");
		btn_grade.addActionListener(mainController.Get_Btn_Grade_Listener(label_grade));
		btn_grade.setFont(new Font("SimSun", Font.BOLD, 14));
		btn_grade.setBounds(140, 10, 120, 40);
		menuPanel.add(btn_grade);
		
		JButton btn_attendance = new JButton("Attendance");
		btn_attendance.addActionListener(mainController.Get_Btn_Attendance_Listener(label_attendance));
		btn_attendance.setFont(new Font("SimSun", Font.BOLD, 14));
		btn_attendance.setBounds(270, 10, 120, 40);
		menuPanel.add(btn_attendance);
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		bottomPanel.setBackground(Color.WHITE);
		bottomPanel.setBounds(10, 434, 851, 57);
		mainPanel.add(bottomPanel);
		bottomPanel.setLayout(null);
		
		JLabel label_warning = new JLabel("");
		label_warning.setForeground(Color.RED);
		label_warning.setFont(new Font("SimSun", Font.BOLD, 14));
		label_warning.setBounds(550, 23, 221, 15);
		bottomPanel.add(label_warning);
		
		JButton btn_update = new JButton("Update");
		btn_update.addActionListener(mainController.Get_Btn_Update_Listener(label_warning));
		btn_update.setFont(new Font("SimSun", Font.BOLD, 14));
		btn_update.setBounds(10, 10, 120, 40);
		bottomPanel.add(btn_update);

	}
}
