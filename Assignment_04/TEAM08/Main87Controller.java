import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
/**
 * <h1>Main87Controller</h1>
 * The Main87Controller class is the class responsible for controller part
 * of the application. ActionListeners of the buttons are handled here
 * <p>
 * CSE564 - Assignment 4
 * Team 8 - Member 7 (ID 87)
 * Integration time: 6 + 2 hours
 *
 * @author Prakhar Sambhar (psambhar)
 * @since 10-26-2020
 */

public class Main87Controller implements ActionListener {
    JButton openRoster,openGrades, openAttendance;
    Repository81StudentRepository repository;
    ObserverTable85 observerTable;
    ObserverPlotter86 plotter;
    Main87 main;
    Reporter84 reporter;
    Grader83 grader;
    Main87Controller(JButton buttons[], ObserverTable85 observerTable, ObserverPlotter86 plotter, Main87 main){
        openRoster = buttons[0];
        openGrades = buttons[1];
        openAttendance = buttons[2];
        this.observerTable = observerTable;
        this.plotter = plotter;
        this.main = main;
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource()== openRoster){

            JFileChooser fc = new JFileChooser();
            fc.setFileFilter(new FileNameExtensionFilter("CSV Input","csv"));
            int i=fc.showOpenDialog(main);
            if(i==JFileChooser.APPROVE_OPTION){
                File f=fc.getSelectedFile();
                String filepath=f.getPath();
                try{
                    repository = new Repository81StudentRepository(filepath);
                    repository.addObserver(observerTable);
                    repository.addObserver(plotter);
                    openAttendance.setEnabled(true);
                    openGrades.setEnabled(true);
                    repository.notifyObservers();
                }catch (Exception ex) {ex.printStackTrace();  }
            }

        }
        else if(actionEvent.getSource() == openAttendance){
            reporter = new Reporter84(repository);
            JFileChooser fc = new JFileChooser();
            fc.setFileFilter(new FileNameExtensionFilter("CSV Input","csv"));
            int i=fc.showOpenDialog(main);
            if(i==JFileChooser.APPROVE_OPTION){
                File f=fc.getSelectedFile();
                String filepath=f.getPath();
                try{
                    reporter.getAttendance(filepath);
                    repository.isChanged();
                    repository.notifyObservers();
                }catch (Exception ex) {ex.printStackTrace();  }
            }


        }
        else if(actionEvent.getSource() == openGrades){
            grader = new Grader83(repository);
            JFileChooser fc = new JFileChooser();
            fc.setFileFilter(new FileNameExtensionFilter("CSV Input","csv"));
            int i=fc.showOpenDialog(main);
            if(i==JFileChooser.APPROVE_OPTION){
                File f=fc.getSelectedFile();
                String filepath=f.getPath();
                try{
                    grader.loadGrades(filepath);
                    repository.isChanged();
                    repository.notifyObservers();
                }catch (Exception ex) {ex.printStackTrace();  }
            }

        }
    }
}
