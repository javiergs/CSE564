import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* The class helps loading attendance data from a chosen csv file and binds it wil the student repository with the help of iterators
*
* @author  Nevedita Kailasam
* Time taken - 4 hours (including meeting with the team)
* 
*/

public class LoadAttendanceFromFile54 {
	public static Map<String, List<Attendance54>> attendanceInfoMap = new HashMap<String, List<Attendance54>>();

	private StudentRepository51 studentRepo;

	public LoadAttendanceFromFile54(StudentRepository51 studentRepo) {
		this.studentRepo = studentRepo;
	}

	public void loadStudentAttendance(String filePath) throws FileNotFoundException, IOException  {
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
		    String line;
		    line = br.readLine();
		    String[] headers = line.split(",");
		    
		    while ((line = br.readLine()) != null) { 
		    	String[] attendanceValues = line.split(",");
		    	if (attendanceValues.length < 2) continue;
		    	List<Attendance54> attList = attendanceInfoMap.getOrDefault(attendanceValues[0], new ArrayList<Attendance54>());
		    	for(int i=1;i<headers.length;i++) {
		    		Attendance54 att = new Attendance54();
		    		att.setDate(headers[i]);
			        att.setMinutes(attendanceValues[i]);
			        attList.add(att);
			        attendanceInfoMap.put(attendanceValues[0].split("@")[0], attList);
		    	}
		    }
		}

		List<Student52> students = new ArrayList<>();
		for (StudentIterator51 iter = studentRepo.getIterator(); iter.hasNext();) {
			Student52 student = (Student52) iter.next();
			StudentAttendance52 studentAttendance = new StudentAttendance52();
			studentAttendance.setStudent(student);
			List<Attendance54> attendanceCard = attendanceInfoMap.get(student.getAsurite());
			if (attendanceCard != null) {
				for (Attendance54 attendance : attendanceCard) {
					studentAttendance.addAttendance(attendance);
				}
				students.add(studentAttendance);
			}
			else
				students.add(student);
		}
		this.studentRepo.updateRepository(students);
	}

}