import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Reporter64Decorator.java This class is to decorate student object with attendance.
 * 
 * @author Nachiappan Lakshmanan
 * @since 10/24/2020
 */

public class Reporter64Decorator {
	Repository61 studentRepository61;

	Reporter64Data attendanceData64;

	Reporter64Decorator(Reporter64Data attendanceData64) {
		this.studentRepository61 = Repository61.getInstance();
		this.attendanceData64 = attendanceData64;
	}

	public int decorateStudentsWithAttendance(String fileName) {
		Iterator<Decorator62StudentInterface> studentRepoIterator = this.studentRepository61.getIterator();
		Map<String, List<Decorator62AttendanceBean>> mapStudentAttendance = this.attendanceData64
				.readAttendanceDataFromFile(fileName);

		int unknown = 0;
		List<Decorator62StudentsAttendanceDecorator> studentsAttendanceDecoratorBeanList = new ArrayList<>();
		while (studentRepoIterator.hasNext()) {
			Decorator62StudentInterface student = studentRepoIterator.next();
			if (mapStudentAttendance.containsKey(student.getAsurite())) {

				List<Decorator62AttendanceBean> attendanceList = mapStudentAttendance.get(student.getAsurite());
				Decorator62StudentsAttendanceDecorator studentAttendanceDecorator = new Decorator62StudentsAttendanceDecorator(
						student);

				for (Decorator62AttendanceBean attendance62 : attendanceList) {
					studentAttendanceDecorator.addAttendance(attendance62);
				}

				studentRepoIterator.remove();
				studentsAttendanceDecoratorBeanList.add(studentAttendanceDecorator);

			} else {
				unknown += 1;
			}

		}

		for (Decorator62StudentsAttendanceDecorator studentAttendancedecorator : studentsAttendanceDecoratorBeanList) {
			this.studentRepository61.add(studentAttendancedecorator);
		}

		return unknown;

	}

}
