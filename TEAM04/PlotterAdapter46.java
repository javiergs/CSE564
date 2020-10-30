import org.jfree.data.category.DefaultCategoryDataset;

import java.util.ArrayList;
import java.util.Iterator;


/**
 * Plotter adapter transforms the student object to DefaultCategoryDataset type which is needed by ApplicationFrame(Plotter).
 */

public class PlotterAdapter46 {
	private Plotter46 adaptee;

	/**
	 * Saves the new Plotter instance as adaptee.
	 */
	public PlotterAdapter46(Plotter46 plotter) {
		this.adaptee = plotter;
	}
/**
 * converts student iterator to PlotterData type. And then converts plotter data to the required data for DefaultCategoryDataset type.
 * @input student iterator
 * @return DefaultCategoryDataset dataset
 */
	public DefaultCategoryDataset transform(Iterator<StudentCoreData42> studentItr){
		ArrayList <PlotterData46> plotterArray = new ArrayList();
		PlotterData46 plData;
		StudentCoreData42 student;
		while (studentItr.hasNext()) {
			student = studentItr.next();
			plData = new PlotterData46();
			ArrayList<AttendanceModel42>  attendanceList = student.getAttendanceList();
			if (attendanceList != null) {
                for(AttendanceModel42 attendance: attendanceList){
					plData.setAttendance((int)attendance.getMinutes());
                }
			}
			plData.setGrades(student.getGradesList());
			plData.setName(student.getFirstName(), student.getLastName());
			plData.setAcademicLevel(student.getAcademicLevel());
			plotterArray.add(plData);
		}

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        ArrayList<GradesModel42> grades;
		String name;
		int attendance;
        for (PlotterData46 pd : plotterArray) {
            grades = pd.getGrades();
			name = pd.getStudentName();
			attendance = pd.getAttendance();
			if (attendance != 0){
				name += " attendance%= " + String.valueOf(attendance);
			}
            if (grades != null)
                for (int i = 0; i < grades.size(); i++) {
                    dataset.addValue(grades.get(i).getMarksObtained(), name, grades.get(i).getAssignmentName());
				}
        }
        return dataset;
	}

	/**
	 * plots the data with the plotter instance the adapter holds. Before plotting it transforms the data to DefaultCategoryDataset.
	 */
	public void plot(Iterator<StudentCoreData42> studentItr) {
		DefaultCategoryDataset dataset = transform(studentItr);
		adaptee.plot(dataset);
	}
}
