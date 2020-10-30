import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * @author: Rosty Hnatyshyn
 * Class that keeps the GUI components together.
 */
public class MainView47 extends JFrame {
    private static final int WIDTH = 1024;
    private static final int HEIGHT = 720;
    private ObserverTable45 observerTable;
    private ObserverPlotter46 plotObserver46;
    private JButton grades_button;
    private JButton attendance_button;

    public MainView47() {
        super();
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setTitle("Assignment 4 Team 4");
        JPanel mainPanel = new JPanel(new GridBagLayout());
        JPanel viewPanel = new JPanel(new GridBagLayout());
        JPanel buttonPanel = new JPanel(new GridBagLayout());
        observerTable = new ObserverTable45();
        plotObserver46 = new ObserverPlotter46();
        grades_button = new JButton("Load Grades");
        attendance_button = new JButton("Load Attendance");
        GridBagConstraints c = new GridBagConstraints();
        add(mainPanel);
        viewPanel.add(observerTable);
        viewPanel.add(plotObserver46);
        c.gridx=1;
        c.gridx=0;
        buttonPanel.add(grades_button,c);
        c.gridx=1;
        buttonPanel.add(attendance_button,c);
        mainPanel.add(viewPanel,c);
        c.gridy = 1;
        mainPanel.add(buttonPanel,c);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
    }

    /**
     * Links the observers in the GUI class to the observables in the model
     * @param observables A list of observables in the model
     */
    public void linkObservers(ArrayList<Observable> observables)
    {
        for(Observable o : observables)
        {
            for(Observer ob : getObservers()) {
                o.addObserver(ob);
            }
            Repository41 repo = (Repository41) o;
            repo.updateObservers();
        }
    }

    /**
     * Gets all the fields in the class that are observers
     * @return An arraylist of observers
     */
    public ArrayList<Observer> getObservers() {
        ArrayList<Observer> observers = new ArrayList<Observer>();
        try {
            Class c = Class.forName(this.getClass().getName());
            Field fieldList[] = c.getDeclaredFields();
            for(int i = 0; i < fieldList.length; i++)
            {
                Field fld = fieldList[i];
                try {
                    Observer o = (Observer) fld.get(this);
                    observers.add(o);
                }
                catch(ClassCastException e) {
                }
            }
        }
        catch (Throwable e)
        {
            e.printStackTrace();
        }
        return observers;
    }

    /**
     * Links the buttons to the controller
     * @param controller The controller
     */
    public void linkController(ActionListener controller)
    {
        //could also add a reflection here to get the buttons and use their names as the action command
        //but that's too much
        grades_button.setActionCommand("Decorate Grades");
        attendance_button.setActionCommand("Decorate Attendance");
        grades_button.addActionListener(controller);
        attendance_button.addActionListener(controller);
    }

    /**
     * Shows the csv file dialogs
     * @return A list of the filepaths that were chosen by the user
     */
    public ArrayList<String> pickCSVFiles()
    {
        ArrayList<String> filePaths = new ArrayList<String>();
        String[] messages = new String[3];
        messages[0] = "Please choose the roster .csv file.";
        messages[1] = "Please choose the grades .csv file.";
        messages[2] = "Please choose the attendance .csv file.";

        for(int i = 0; i < 3; i++)
        {
            JOptionPane.showMessageDialog(this, messages[i]);
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV Files", "csv","csv");
            fileChooser.setFileFilter(filter);
            int result = fileChooser.showOpenDialog(this);
            if(result == JFileChooser.APPROVE_OPTION)
            {
                File file = fileChooser.getSelectedFile();
                filePaths.add(file.getAbsolutePath());
            }
        }
        return filePaths;
    }


}
