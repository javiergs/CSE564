import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Workspace extends JPanel implements MouseListener, MouseMotionListener {

    int preX, preY;
    int pressOut = -1;

    public Workspace() {
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        
        // this is a problem
        int[] order = DataContainer.getInstance().travelingOrder();
        
        g2.setColor(Color.RED);
        for (int i = 0; i < DataContainer.getInstance().size(); i++) {
            if (i == DataContainer.getInstance().size() - 1) {
                DataContainer.getInstance().get(
                  order[i]).drawConnect(DataContainer.getInstance().get(0), g2);
            } else {
                DataContainer.getInstance().get(
                  order[i]).drawConnect(DataContainer.getInstance().get(order[i + 1]), g2);
            }
            DataContainer.getInstance().get(i).draw(g2);
        }
    }
    
    private int citySelected(MouseEvent e) {
        int citySelected = -1;
        for (int i = 0; i < DataContainer.getInstance().size(); i++) {
            if (DataContainer.getInstance().get(i).contains(e.getX(), e.getY())) {
                citySelected = i;
            }
        }
        return citySelected;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (citySelected(e) == -1) {
            City newCity = new City("unnamed", e.getX(), e.getY(), 10, 10);
            String result = (String) JOptionPane.showInputDialog(
                    e.getComponent(),
                    "Type the name of the new city",
                    "City Name",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    null,
                    "unnamed"
            );
            if(result != null && result.length() > 0){
                DataContainer.getInstance().add(newCity);
                newCity.setLabel(result);
            }
            repaint();
        }
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        pressOut = citySelected(e);
        if (pressOut == -1) return;
        City city = DataContainer.getInstance().get(pressOut);
        preX = city.getX() - e.getX();
        preY = city.getY() - e.getY();
        city.move(preX + e.getX(), preY + e.getY());
        repaint();
    }
    
    @Override
    public void mouseDragged(MouseEvent e) {
        if (pressOut == -1) return;
        City city = DataContainer.getInstance().get(pressOut);
        city.move(preX + e.getX(), preY + e.getY());
        repaint();
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
        if (pressOut == -1) return;
        City city = DataContainer.getInstance().get(pressOut);
        city.move(preX + e.getX(), preY + e.getY());
        repaint();
        pressOut = citySelected(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
    @Override
    public void mouseMoved(MouseEvent e) {}

}
