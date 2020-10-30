import javax.swing.*;

import java.awt.BorderLayout;
import java.io.File;
import javax.swing.filechooser.FileFilter;

public class Main27Controller
{	
	private JFrame frame;
	private StudentRepository21 repo;
	private Grader23 grader;
	private AttendanceReport24 reporter;
	private ObserverTable25 obtable;
	private ObserverPlotter26 obplot;
	
	public Main27Controller(JFrame frame) {
		this.frame = frame;	
	}

	public void details() {
		// TODO Auto-generated method stub
		File rosterFilePath = openFile();
		repo = new StudentRepository21(rosterFilePath.getAbsolutePath());
		obtable = new ObserverTable25();
	    obplot = new ObserverPlotter26();
	    repo.addObserver(obtable);
	    repo.addObserver(obplot);
	    repo.notifyObservers();
	    frame.add(obtable, BorderLayout.CENTER);
	    frame.add(obplot.getPanel(), BorderLayout.SOUTH);
	    frame.setVisible(true);	
	}

	public void grades() {
		// TODO Auto-generated method stub
		File graderPath = openFile();
		grader = new Grader23(repo, graderPath.getAbsolutePath());
	}

	public void attendance() {
		// TODO Auto-generated method stub
		File attendancePath = openFile();
        reporter = new AttendanceReport24(repo, attendancePath.getAbsolutePath());		
	}

	public void showResults() {
		// TODO Auto-generated method stub			
		    repo.notifyObservers();		    
	}
	
	public File openFile()
	{
		JFileChooser fileChooser = new JFileChooser();
        fileChooser.addChoosableFileFilter(new FileFilter() {
            public String getDescription()
            {
                return "CSV files (*.csv)";
            }
         
            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                }
                else {
                    return f.getName().toLowerCase().endsWith(".csv");
                }
            }
        });
        fileChooser.setAcceptAllFileFilterUsed(false);
        int option = fileChooser.showOpenDialog(frame);
        if(option == JFileChooser.APPROVE_OPTION){
           File file = fileChooser.getSelectedFile();
           return file;
        }
		return null;
	}

}
