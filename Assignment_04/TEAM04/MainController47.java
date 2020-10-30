import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainController47 implements ActionListener {
    MainModel47 model;

    public MainController47(MainModel47 model)
    {
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        switch(action){
            case "Decorate Attendance":
                model.decorateAttendance();
                break;
            case "Decorate Grades":
                model.decorateGrades();
                break;
            default:
                System.out.println("Action not supported.");
                break;
        }
    }
}
