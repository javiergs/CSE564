/**
 * Repository101StudentRepository creates a list of student objects from the given roster file.
 * Time taken to implement ~ 2 hours.
 * 
 * @author Tanveer
 * @version 1.1
 * @since 10-24-2020
 *
 */
import java.io.*;
import java.util.*;

public class Repository101StudentRepository extends Observable implements Repository101 {
	List<Decorator102Student> students = new ArrayList<Decorator102Student>();

	@Override
	public Repository101Iterator getIterator() {
		return new Repository101StudentIterator(students);
	}
	

	public void createStudentObjectsFromFile(String rosterFilePath) {
		students.clear();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(rosterFilePath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		String line = "";
		String splitBy = ",";  
		try {
			br.readLine();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			while ((line = br.readLine()) != null)     
			{  
				if((line.split(splitBy)).length>0 && line.length()>0)
				{
					String[] studentData = line.split(splitBy);
					
					Decorator102Student student = new Decorator102StudentCoreData(studentData[0], studentData[1], studentData[2], studentData[3], studentData[4], studentData[5]);
					students.add(student);
				}
			
			}
		} catch (IOException e) {
			e.printStackTrace();
		}  
	}
	
	public void notifyTable() {
		setChanged();
		notifyObservers();
	}
	
	public List<Decorator102Student> getStudentList() {
		return students;
	}

}
