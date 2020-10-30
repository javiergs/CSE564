/*
@author Kanti Nizampatnam
Time required: 6 hours
Description: Observer Plotter class which plots grades retrieved from the table
when there is some change in the student class (grader.x.csv)

NOTE:
Before the execution make sure jcommon and jfree jar files are included in the library.
*/



import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DatasetChangeEvent;
import org.jfree.data.general.DatasetChangeListener;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import java.util.*;

public class Plotter76Observer extends ApplicationFrame implements Observer{
	
	 public Plotter76Observer( String applicationTitle , String chartTitle ) {
	        super( applicationTitle );
	        JFreeChart barChart = ChartFactory.createBarChart(
	                chartTitle,
	                "Exam Type",
	                "Score",
	                createDataset(),
	                PlotOrientation.VERTICAL,
	                true, true, false);

	        ChartPanel chartPanel = new ChartPanel( barChart );
	        chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );
	        setContentPane( chartPanel );
	    }

    @Override
    public void update(Observable o, Object arg) {

    	Iterator71 iterator = ((StudentRepository71Iterator)o).getIterator();
    	while(iterator.hasNext())
		{
			Student71 obj = (Student71) iterator.next();
		}
        Iterator iterator = (Iterator) getStudentIterator(o);
        ArrayList<String> column_Names = new ArrayList<>();
        }
    
    public StudentRepository71Iterator getStudentIterator(Observable o) {
        return (StudentRepository71Iterator) ((StudentRepository71Iterator) o).getIterator();
    }
    
    private CategoryDataset createDataset() {

        // InputStream in = new FileInputStream( new File( "C:\\Users\\Kanti Nizampatnam\\Downloads\\grades.x.csv" ) );
        // BufferedReader reader = new BufferedReader(new InputStreamReader(in ) );
        // StringBuilder out = new StringBuilder();
         String line;
         final CategoryDataset dataset = createDataset(in);

         final DefaultCategoryDataset dataset =
                 new DefaultCategoryDataset( );
         //dataset.addChangeListener(
        		 //new DatasetChangeListener() {});


         return dataset;
     }
    
    
    public static ArrayList<ArrayList<String>> findData(Iterator iterator) {

        LinkedList<Grades72> grades_List = StudentGrades72Decorator.grades;
        if (grades_List.size() > 0) {
            for (Grades72 gList : grades_List) {
                student.add(String.valueOf(gList.result));
            }
        }

        data_List.add(student);
        return data_List;
    }
    
    public static void main( String[ ] args ) {
        ObserverPlotter76 chart = new ObserverPlotter76("Score,
                "student scores");
        chart.pack( );
        RefineryUtilities.centerFrameOnScreen( chart );
        chart.setVisible( true );
    }
}
