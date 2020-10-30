/**
 * Plotter file which extends JPanel and Observes StudentRepository51 
 * 
 * @author tkarna
 * @since 10/28/2020
 * 
 * 
 * Time Required - 3 hours
 * 
 */
import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

// Add jcommon-1.0.17.jar and jfreechart-1.0.14.jar external libraries

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

@SuppressWarnings("deprecation")
public class ObserverPlotter56 extends JPanel implements Observer {
	private Rectangle screenSize = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();

	public ObserverPlotter56() {
		setLayout(null);
		setBorder(BorderFactory.createLineBorder(Color.black));
		setBounds(screenSize.width / 2 + 20, 80, screenSize.width - screenSize.width / 2 - 30,
				screenSize.height - screenSize.height / 7);
	}

	@Override
	public void update(Observable o, Object arg) {
//		// TODO Auto-generated method stub
		StudentIterator51 iter = ((StudentRepository51) o).getIterator();
		this.removeAll();

		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		int i = 0;
		for (iter = ((StudentRepository51) o).getIterator(); iter.hasNext();) {

			Student52 student = (Student52) iter.next();
			for (i = 0; student.getGrades() != null && i < student.getGrades().size(); i++) {
				String quiz = student.getGrades().get(i).getTitle();
				String score = student.getGrades().get(i).getPercentageObtained();
				String name = student.getGrades().get(i).getTitle();
				int s = Integer.parseInt(score);
				dataset.addValue(s, quiz, name);

			}
			for (i = 0; student.getAttendance() != null && i < student.getAttendance().size(); i++) {

				dataset.addValue(Integer.parseInt(student.getAttendance().get(i).getMinutes()),
						student.getAttendance().get(i).getDate(), student.getAttendance().get(i).getDate());

			}
		}

		JFreeChart barChart = ChartFactory.createBarChart("Grades", "Students", "Score", dataset,
				PlotOrientation.VERTICAL, true, true, false);

		ChartPanel chartPanel = new ChartPanel(barChart);
		chartPanel.setBounds(10, 10, 500, 500);
		chartPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		chartPanel.validate();
		this.add(chartPanel);
		this.repaint();

	}

	

}
