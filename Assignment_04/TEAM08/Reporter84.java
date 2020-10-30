
/**
 * CSE564- Team 8
 * Reporter84 class responsible for loading data of students 
 * from attendance CSV and adding their attendance
 * date and minute wise.
 * 
 * @author-Sarvansh Prasher
 * @number- 84
 * @date-10/26/2020
 * @version-1.0
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Reporter84 {
	private Repository81StudentRepository studentRepository;
	private String[] dateHeadings;

	public Reporter84(Repository81StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public int getAttendance(String filePath) throws FileNotFoundException {
		try {
			File myObj = new File(filePath);
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				addDateHeadings(data);
				break;
			}
			int newStudentsInList = 0;
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				String[] attendaceDetails = data.split(",");
				boolean attendaceAddition = addAttendanceForStudent(attendaceDetails);
				if (!attendaceAddition)
					newStudentsInList += 1;
			}
			myReader.close();
			return newStudentsInList;
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
			return 0;
		}
	}

	private void addDateHeadings(String data) {
		dateHeadings = data.split(",");
	}

	private boolean addAttendanceForStudent(String[] data) {
		boolean attendanceAddedForStudent = false;
		if (data.length > 0) {
			Student82 studentAsurite = getStudentDetails(data[0]);
			if (studentAsurite != null) {
				ArrayList attendance = new ArrayList();
				for (int i = 1; i < data.length; i++) {
					attendance.add(new Reporter84Attendance(dateHeadings[i], data[i]));
				}
				studentAsurite = new StudentAttendance82(studentAsurite);
				studentAsurite.add(attendance);
				studentRepository.replaceStudent(studentAsurite, data[0]);
				attendanceAddedForStudent = true;
			}
		}
		return attendanceAddedForStudent;
	}

	private Student82 getStudentDetails(String studentAsurite) {
		String key = studentAsurite.split("@")[0];
		Repository81Iterator iter = studentRepository.getIterator();
		while (iter.hasNext()) {
			Student82 student = (Student82) iter.next();
			if (student.getAsurite().equals(key)) {
				return student;
			}
		}
		return null;
	}
}
