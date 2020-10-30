import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

import java.util.ArrayList;

/**
* Plotter class is an application frame. It plots the data it receives in DefaultCategoryDataset type. and updates the chartPanel instance.
*
* @author  Idhant Haldankar
* @id ihaldank
*/
public class Plotter46 extends ApplicationFrame {
    private ChartPanel chartPanel;


    public Plotter46() {
        super("Students Scores for assignments and Quizzes.");
    }


    public void plot(DefaultCategoryDataset dataset) {
        JFreeChart barChart = ChartFactory.createBarChart(
                "Students Scores for assignments and Quizzes.",
                "Students",
                "Score",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        chartPanel = new ChartPanel(barChart);
        setContentPane(chartPanel);
    }

    public ChartPanel getChartPanel() {
        return this.chartPanel;
    }



}
