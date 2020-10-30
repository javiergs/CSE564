import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Reporter64Data.java - This class is to load attendance data from attendance-x.csv file returns a
 * list of attendance object, each object corresponds to a row in the attendance
 * file.
 * 
 * @author Nachiappan Lakshmanan
 * @since 10/24/2020
 */
public class Reporter64Data {

	public List<String[]> readFileLineByLine(String fileName) {
		List<String[]> attendanceFile = new ArrayList<>();
		try {
			File myObj = new File(fileName);
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String line[] = myReader.nextLine().split(",");
				attendanceFile.add(line);
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return attendanceFile;
	}

	public void createAttendanceRecordForEachStudent(int index, Map<String, List<Decorator62AttendanceBean>> mapStudentAttendance,
			List<Decorator62AttendanceBean> lstDateObjects, String record[]) {
		try {
			if (index == 0) {
				List<Decorator62AttendanceBean> attendanceList = new ArrayList<>();
				record[index] = trimUserEmail(record[index]);
				if (record[index].length() != 0) {
					mapStudentAttendance.put(record[index], attendanceList);
				}
			} else {
				for (Decorator62AttendanceBean eachDate : lstDateObjects) {
					Decorator62AttendanceBean temp = (Decorator62AttendanceBean) eachDate.clone();
					temp.setMinutes(Integer.valueOf(record[index]));
					if (mapStudentAttendance.containsKey(record[0])) {
						mapStudentAttendance.get(record[0]).add(temp);
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Number format not supported exception/clone not possible exception");
		}
	}

	public Map<String, List<Decorator62AttendanceBean>> readAttendanceDataFromFile(String fileName) {
		List<String[]> attendanceFile = readFileLineByLine(fileName);
		boolean header = true;
		Map<String, List<Decorator62AttendanceBean>> mapStudentAttendance = new HashMap<>();
		List<Decorator62AttendanceBean> lstDateObjects = new ArrayList<>();

		for (int i = 0; i < attendanceFile.size(); i++) {
			String record[] = (attendanceFile.get(i));
			for (int j = 0; j < record.length; j++) {
				record[j] = record[j].trim();
				if (!header) {
					createAttendanceRecordForEachStudent(j, mapStudentAttendance, lstDateObjects, record);
				} else {
					if (j != 0) {
						Decorator62AttendanceBean attendance62 = new Decorator62AttendanceBean();
						attendance62.setDate(record[j]);
						lstDateObjects.add(attendance62);
					}

				}
			}
			header = false;
		}
		return mapStudentAttendance;
	}

	public static String trimUserEmail(String userEmail) {
		return userEmail.split("@")[0];
	}

}
