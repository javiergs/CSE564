import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Main extends JFrame implements ActionListener {

    public Main() {
        Workspace drawArea = new Workspace();
        add(drawArea);
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu ("File");
        JMenuItem clear = new JMenuItem ("Clear");
        JMenuItem save = new JMenuItem ("Save...");
        JMenuItem load = new JMenuItem ("Load...");
        menuBar.add(menu);
        menu.add(clear);
        menu.add(save);
        menu.add(load);
        setJMenuBar(menuBar);
        clear.addActionListener(this);
        save.addActionListener(this);
        load.addActionListener(this);
    }
    
    public static void main(String[] args) {
        DataContainer.getInstance().add(new City("Tempe", 100, 100, 10, 10));
        DataContainer.getInstance().add(new City("Phoenix", 300, 300, 10, 10));
        Main main = new Main();
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setSize(500, 500);
        main.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Clear")) {
            DataContainer.getInstance().clear();
            repaint();
        } else if (e.getActionCommand().equals("Save...")) {
            String path = (String) JOptionPane.showInputDialog(
                    this,
                    "File Path",
                    "Save File...",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    null,
                    "userCreated.tsp"
            );
            if (path != null && path.length() > 0) {
                try {
                    DataContainer.getInstance().saveToFile(path);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        } else if (e.getActionCommand().equals("Load...")) {
            String path = (String) JOptionPane.showInputDialog(
                    this,
                    "File Path",
                    "Load File...",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    null,
                    "userCreated.tsp"
            );
            if (path != null && path.length() > 0) {
                try {
                    DataContainer.getInstance().readFile(path);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            repaint();
        }
    }

}
