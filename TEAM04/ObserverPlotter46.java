import java.awt.*;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

/**
 * Observer Panel which observes the student object data and updates the Plotter instance which updates the ApplicationFrame.
 * * @author  Idhant Haldankar
* @id ihaldank
 */
public class ObserverPlotter46 extends JPanel implements Observer{

    private JPanel resultPanel;
    private Plotter46 plotterInstance;
    private PlotterAdapter46 adapter;

    /**
     * Display an empty panelchart when constructor is called.
     */
	public ObserverPlotter46() {
		super(new GridLayout());
        resultPanel = new JPanel();
        resultPanel.setLayout(new GridBagLayout());
        add(resultPanel);
        setVisible(true);
	}

	/**
	 * get the iterator from student repository
	 * delegate the plotting task to PLotter Adapter where conversion happens.
	 */
	@Override
	public void update(Observable o, Object arg) {
		Iterator studentItr = ((Repository41)o).getIterator();
		plotterInstance = new Plotter46();
		adapter = new PlotterAdapter46(plotterInstance);
		adapter.plot(studentItr);
		resultPanel.removeAll();
		resultPanel.add(plotterInstance.getChartPanel());
		resultPanel.updateUI();
	}

}
