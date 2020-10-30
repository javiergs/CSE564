import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * This class is an Observer of a StudentRepository object. Calling update will
 * generate an updated dataset for a bar chart of student information.
 *
 * Since this class inherits from JPanel, simply call the default constructor
 * and add the resulting ObserverPlotter object to the parent component. You
 * must attach this object as an observer to the observable StudentRepository
 * object, and upon calling 'notifyObservers()' will update the table
 * accordingly.
 *
 * @author Jonathan MacArthur (jmacarth)
 * @since 10/24/2020
 */

public class ObserverPlotter66 extends JPanel implements Observer {

	private DefaultCategoryDataset data;

	/**
	 * Constructor for a modular plotting panel.
	 *
	 * @param chartTitle String title to be placed on the graph
	 * @param xAxisLabel String to label the x-axis values
	 * @param yAxisLabel String to label the y-axis values
	 * @param plotWidth  Desired display width for the plot
	 * @param plotHeight Desired display height for the plot
	 */
	public ObserverPlotter66(String chartTitle, String xAxisLabel, String yAxisLabel,
							 int plotWidth, int plotHeight) {
		// Establish Data and Chart
		data = new DefaultCategoryDataset();

		JFreeChart barChart = ChartFactory.createBarChart(chartTitle,
				xAxisLabel,
				yAxisLabel,
				data,
				PlotOrientation.VERTICAL,
				true, true, false);

		CategoryPlot plot = (CategoryPlot) barChart.getPlot();
		((NumberAxis) plot.getRangeAxis()).setRange(0, 100);

		ChartPanel chartPanel = new ChartPanel(barChart);
		this.setPreferredSize(new Dimension(plotWidth, plotHeight));
		add(chartPanel);
	}

	/**
	 * Override update method for the plot.
	 *
	 * @param o   An observable object containing data to plot
	 * @param arg Additional argument slot if needed
	 */
	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof Repository61) {
			updateStudentRepositoryPlot((Repository61) o);
		}
	}

	/**
	 * Handles the updating of the plot when given a student repo object.
	 *
	 * @param repository the repository holding the student data
	 */
	public void updateStudentRepositoryPlot(Repository61 repository) {
		// Remove blank row added for students without grades
		if (data.getRowCount() != 0 && data.getRowKey(0).equals("Assignments"))
			data.removeRow(0);

		for (Iterator iter = repository.getIterator(); iter.hasNext();) {
			Decorator62StudentInterface student = (Decorator62StudentInterface) iter.next();
			String studentID = student.getAsurite();

			List<Decorator62GradeBean> grades = student.getGrades();

			if (grades != null) {
				// Add Values for ASURites with quiz scores
				for (int i = 0; i < grades.size(); i++) {
					Decorator62GradeBean currentGrade = grades.get(i);

					String category = currentGrade.getAssesmentName();
					int score = currentGrade.getScore();

					updatePlot(score, category, studentID);
				}
			} else {
				// Add ASURites, but leave space for data
				data.addValue(0, "Assignments", studentID);
			}
		}
	}

	/**
	 * Updates the Plot with provided information.
	 *
	 * @param value the value of the data to plot
	 * @param category the category to which the score belongs to
	 * @param id the identity of the x-axis label to which the category/score belongs
	 */
	public void updatePlot(int value, String category, String id) {
		data.addValue(value, category, id);
	}
}