
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Handles the attendance file and decorates the student object with attendance
 * @author Satya Vundavalli
 * @version 2.0
 * 
 * It took approximately 2 hrs of work
 */

public class Reporter104 {
	List<String> dates = new ArrayList<>();
	Map<String, List<String>> attendanceMap = new HashMap<>();
	
	/**
	 * Decorates student object with attendance
	 * @param repo Student repository that gives iterator
	 * @param filePath path to the attendance file
	 */
	public void decorate(Repository101StudentRepository repo, String filePath) {
		readFileToMap(filePath);
		for(Repository101Iterator iter = repo.getIterator(); iter.hasNext();) {
			Decorator102Student student = (Decorator102Student)iter.peek();
			if(student != null) {
				Decorator102Student attendanceCard = new Decorator102StudentAttendance();
				((Decorator102StudentAttendance) attendanceCard).add(student);				
				
				List<String> currAttendance = attendanceMap.get( student.getAsurite() + "@asu.edu");
				for(int i=0; i<currAttendance.size(); i++) {
					
					((Decorator102StudentAttendance) attendanceCard).addAttendance(dates.get(i), Integer.parseInt(currAttendance.get(i)));
				}	
				iter.setNext(attendanceCard);
			}
		}
		repo.notifyTable();
	}
	
	/**
	 * Helper method to read file and store the data in a map
	 * @param filePath path to the attendance file
	 */
	public void readFileToMap(String filePath) {
		try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
			String colLine = br.readLine();
			String[] colNamesSplit = colLine.split(",", 2);
			dates = Arrays.asList(colNamesSplit[1].split(","));
			String nextLine = br.readLine();
			while(nextLine != null) {
				String[] parts = nextLine.split(",", 2);
				if(nextLine.length()>0 && parts.length>0) {
					attendanceMap.put(parts[0], Arrays.asList(parts[1].split(",")));
				}
				nextLine = br.readLine();
			}
		}catch(Exception e) {
			System.out.println("Error while trying to read file!");
			e.printStackTrace();
		}
	}


}
