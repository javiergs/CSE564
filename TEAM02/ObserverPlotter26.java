package dp;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;


public class ObserverPlotter26 extends JPanel implements Observer {


    private StudentRepository21 studentRepository;
    JFreeChart tempBarChart = ChartFactory.createBarChart(
            "Student bar chart",
            "Category",
            "Score",
            createDataset(),
            PlotOrientation.VERTICAL,
            true, true, false);
    private ChartPanel chartPanel = new ChartPanel(tempBarChart);

    public ObserverPlotter26() { }

    private CategoryDataset createDataset() {

        final DefaultCategoryDataset dataset =
                new DefaultCategoryDataset();

        if (studentRepository != null) {

            for (Iterator21 it = studentRepository.getIterator(); it.hasNext(); ) {

                Decorator22StudentCoreData student = (Decorator22StudentCoreData) it.next();
                List<Decorator22StudentGrades> gradesList = student.getGradesList();

                if (gradesList != null) {
                    System.out.println("In observer plotter 26");
                    for (Decorator22StudentGrades studentGrades22 : gradesList) {
                        dataset.addValue(studentGrades22.score, Integer.toString(student.getId()), studentGrades22.name);
                    }
                } else {
                    System.out.println("grade list is null");
                }
            }
        }

        return dataset;
    }

    @Override
    public void update(Observable o, Object args) {

        this.studentRepository = (StudentRepository21) o;
        // update the UI, whenever repository changes
        JFreeChart barChart = ChartFactory.createBarChart(
                "Student bar chart",
                "Category",
                "Score",
                createDataset(),
                PlotOrientation.VERTICAL,
                true, true, false);



        chartPanel.setChart(barChart);
        //chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
        this.add(chartPanel);
        this.setPreferredSize(new Dimension(400, 600));
        SwingUtilities.updateComponentTreeUI(this);
    }
}
