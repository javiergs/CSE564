import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
/*
* Name : Mahendra Rao
* ID : mrrao1
* CSE 564 Assignment 4
* Observer pattern bar graph plotter
*/
public class ObserverPlotter86 extends JPanel implements Observer {

	private ChartPanel chartPanel;
	private DefaultCategoryDataset dataset;

	public ObserverPlotter86(String chartTitle, String xAxis, String yAxis) {
		dataset = new DefaultCategoryDataset();
		JFreeChart barChart = ChartFactory.createBarChart(chartTitle, xAxis, yAxis, dataset,
				PlotOrientation.HORIZONTAL, true, true, false);
		CategoryPlot plot = (CategoryPlot) barChart.getPlot();
		((NumberAxis) plot.getRangeAxis()).setRange(0, 200);
		ChartPanel chartPanel = new ChartPanel(barChart);
		add(chartPanel);
	}

	@Override
	public void update(Observable observable, Object arg) {
		if (observable instanceof Repository81StudentRepository) {
			dataset.clear();
			Repository81StudentRepository repository = (Repository81StudentRepository) observable;
			for (Repository81Iterator iter = repository.getIterator(); iter.hasNext();) {
				Decorator82StudentInterface student = (Decorator82StudentInterface) iter.next();
				List<Grader83Grade> grades = (List<Grader83Grade>) student.decorations.get("Grades");
				if (grades != null) {
					for(Grader83Grade g : grades)
						dataset.addValue(g.getScore(), g.getName(), student.getAsurite());
				}
				else {
					dataset.addValue(0, "Assignment1", student.getAsurite());
				}
			}
		}
	}
}
