package src;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import src.Decorator32;
import src.Decorator32StudentAttendance;
import src.Decorator32StudentCore;
import src.Decorator32StudentDecorator;
import javax.swing.*;
import java.util.*;
/**
 * ObserverPlotter36 is the observer file that handles the attendance plotting using the data from the student repository for the application with the help of jfreechart library
 *
 * @author  Akshay Kumar Dileep
 * @version 1.0
 * @since   2019-10-25, number of hours = 2.5 hours - 1 1/2hr meeting 1 hour coding
 */
public class ObserverPlotter36 extends JPanel implements Observer {
    private String chartTitle;
    public ObserverPlotter36() {
        super();
        this.chartTitle = "Attendance";
        Map<String,Decorator32StudentDecorator> map = null;
        JFreeChart barChart = ChartFactory.createBarChart(
                chartTitle,
                "Students",
                "Attendance Percentage",
                createDataset(map),
                PlotOrientation.VERTICAL,
                true, true, false);
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
        add(chartPanel);
    }
    public JPanel getPanel(){
        return this;
    }
    @Override
    public void update(Observable o, Object arg) {
        JFreeChart barChart = ChartFactory.createBarChart(
                chartTitle,
                "Students",
                "Attendance Percentage",
                createDataset(arg),
                PlotOrientation.VERTICAL,
                true, true, false);
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
        removeAll();
        add(chartPanel);
        revalidate();
    }
    private CategoryDataset createDataset(Object arg ) {
        final DefaultCategoryDataset dataset =
                new DefaultCategoryDataset( );
        if(arg == null){
            return dataset;
        }
        Iterator it = ((Map<String, Decorator32StudentDecorator>) arg).entrySet ( ).iterator ( );
        while (it.hasNext ( )) {
            Map.Entry pair = (Map.Entry) it.next ( );
            String Name = ((Decorator32StudentCore) pair.getValue ( )).getAsurite ( );
            String AttendanceValue = "0";
            try {
                HashMap<String, Integer> map = (HashMap<String, Integer>) ((Decorator32StudentAttendance) ((Decorator32StudentDecorator) pair.getValue ( )).getStudent ( )).getAttendance ( );
                for (Map.Entry<String, Integer> entry : map.entrySet ( )) {
                    AttendanceValue = entry.getValue().toString();
                }
                dataset.addValue( Integer.parseInt(AttendanceValue) , "Latest Attendance Recorded " , Name );
                it.remove ( );
            } catch (Exception e) {
                dataset.addValue( Integer.parseInt(AttendanceValue) , "Attendance " , Name );
            }
        }
        return dataset;
    }
}