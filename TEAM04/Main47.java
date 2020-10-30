import javax.swing.JOptionPane;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class Main47 {
    public static void main(String[] args) {

        MainView47 ui = new MainView47();
        ArrayList<String> filePaths = ui.pickCSVFiles();

        if(filePaths.size() == 3)
        {
            MainModel47 model = new MainModel47(filePaths);
            MainController47 controller = new MainController47(model);
            ui.linkObservers(model.getObservables());
            ui.linkController(controller);
        }
        else
        {
            JOptionPane.showMessageDialog(ui, "You did not choose 3 csv files. Closing the application.");
            ui.dispatchEvent(new WindowEvent(ui, WindowEvent.WINDOW_CLOSING));
        }

    }

}