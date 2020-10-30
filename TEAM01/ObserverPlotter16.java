package team1.kings;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import team1.gaurav.Repository11;
import team1.gaurav.Repository11Iterator;
import team1.sukhpreet.Decorator12;
import team1.sukhpreet.Decorator12SingleGrade;

import javax.swing.*;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class ObserverPlotter16 extends JPanel implements Observer {

    private Repository11 repository;
    private DefaultCategoryDataset dataset = new DefaultCategoryDataset();

    public ObserverPlotter16(Repository11 subject) {
        this.repository = subject;
        JFreeChart barChart = ChartFactory.createBarChart(
                "Grades for students",
                "Assignments",
                "Grade",
                createDataset(), PlotOrientation.VERTICAL,
                true,
                true,
                false);
        ChartPanel panelBarChart = new ChartPanel(barChart);
        add(panelBarChart);
    }

    //Method creates a dataset from the studentList 
    public CategoryDataset createDataset() {

        Repository11Iterator iterator = repository.getIterator();

        while (iterator.hasNext()){
            Decorator12 student = iterator.next();
            List<Decorator12SingleGrade> grades = student.getGrades();
            for (Decorator12SingleGrade grade : grades) {
                dataset.addValue(grade.getGrade(), student.getLastName(), grade.getAssignmentName());
            }
        }
        return dataset;
    }

    public void setDataset(CategoryDataset categoryDataset) {
        this.dataset = (DefaultCategoryDataset) categoryDataset;
    }


    @Override
    public void update(Observable o, Object arg) {
        setDataset(createDataset());
    }
}
