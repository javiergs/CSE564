import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Scanner;

public class Repository41 extends Observable{
	private static ArrayList<StudentCoreData42> students;

	/**
	 * Reads the roster.csv and updates the repository
	 * @param filePath
	 */


	public void readFile(String filePath) {
		try {
			students = new ArrayList<>();
			FileInputStream fis = new FileInputStream(filePath);
			Scanner sc = new Scanner(fis);
			String line = sc.nextLine();
			int i = 0;
			while(sc.hasNext()) {
				line = sc.nextLine();
				line.trim();
				if(!line.equals("")) {
					String[] fields = line.split(",");
					StudentCoreData42 s = new StudentCoreData42();
					s.setId(fields[0]);
					s.setFirstName(fields[1]);
					s.setLastName(fields[2]);
					s.setProgram(fields[3]);
					s.setAcademicLevel(fields[4]);
					s.setAsurite(fields[5]);
					this.addStudent(s);
				}
			}
			sc.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		updateObservers();
	}
	
	/**
	 * adds Student Object to students list
	 * @param student
	 */
	public void addStudent(StudentCoreData42 student) {
		students.add(student);
	}
	
	/**
	 * notifies the observers
	 */
	public void updateObservers() {
		setChanged();
		notifyObservers();
	}
	
	/**
	 * returns the iterator
	 * @return
	 */
	public Iterator getIterator() {
		return students.iterator();	
	}
}