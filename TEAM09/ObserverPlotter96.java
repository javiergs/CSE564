/*
 * @Author : Akash Krishna Srivastava
 * Team : 96
 * ASUid: 1217085597
 *
 * Reference from:
 * CSE564: Lecture Slides
 * https://www.tutorialspoint.com/jfreechart/jfreechart_bar_chart.htm
 * */

import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset; 
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;

/**
* Class for gathering values and updating plot
* Pattern - Observer
*/

//Added suppress warning since type Observer is deprecated from version 9
@SuppressWarnings("deprecation")
public class ObserverPlotter96 extends JPanel implements Observer
{
    /*
    Dimensions of the chart
     */
    private int chartWidth = 600;
    private int chartHeight = 400;

    @Override
    public void update(Observable o, Object arg)
    {   
        // for updation of the chart
        this.removeAll();

        // Creating a bar chart
        JFreeChart barChart = ChartFactory.createBarChart(
                "Student's Grades",
                "Student's Name",
                "Student's Score",
                createDataset((Student91Observable) o),
                PlotOrientation.VERTICAL,
                true, true, false);

        // Create a Jpanel
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(chartWidth, chartHeight));
        this.add(chartPanel);
        SwingUtilities.updateComponentTreeUI(this);
    }

    /**
    * Method creates a dataset with name and score to be plotted
    * 
    * params: namesRepository
    * returns: dataset
    * 
    */
    private CategoryDataset createDataset(Student91Observable namesRepository)
    {
        final DefaultCategoryDataset data = new DefaultCategoryDataset();

        for (Iterator it = namesRepository.getIterator();it.hasNext();)
        {
            // Get Students data
            Student92CoreData student = (Student92CoreData)it.next();
            List<Grade92Model> grade = (List<Grade92Model>)student.get("Grade");

            // Check if grade file is loaded or not to make it compatible with main
            if(grade == null)
            {
                return null;
            }
            for(int index = 0; index < grade.size(); index++)
            {
                String score = grade.get(index).score;
                String assignmentName = grade.get(index).colName;

                // Add name and score to the graph
                data.addValue(Integer.parseInt(score),  assignmentName, student.getFirstName());
            }
        }
        return data;
    }
    
    /**
     * public static void main(String args[])
     * {
     * 
     *      Used this for testing with dummy data
     * 
     * }
     */
}
