
/**
 * This class is for reading the file and storing student objects
 * It also extends Observable in order to notify the observers when
 * an object is added
 * 
 * @author Ashwath Reddy Koppala(akoppala)
 * @since 10/23/2020
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Scanner;

class Repository61 extends Observable {
	private ArrayList<Decorator62StudentInterface> studentList = new ArrayList<Decorator62StudentInterface>();
	static Repository61 studentRepository61;

	private Repository61() {
	}

	public static Repository61 getInstance() {
		if (studentRepository61 == null) {
			studentRepository61 = new Repository61();
		}
		return studentRepository61;
	}

	public void add(Decorator62StudentInterface student) {
		studentList.add(student);
		setChanged();
		notifyObservers();
	}

	public void readFile(String file) {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(file));
			reader.readLine();
			String line = null;
			Scanner scanner = null;
			int index = 0;
			int count = 0;
			while ((line = reader.readLine()) != null) {
				if (line.replace(",", "").length() > 0) {
					Decorator62StudentInterface st = new Decorator62SimpleStudent();
					scanner = new Scanner(line);
					scanner.useDelimiter(",");
					while (scanner.hasNext()) {
						String data = scanner.next();
						if (data.length() > 0)
							if (index == 0)
								st.setId(Integer.parseInt(data));
							else if (index == 1)
								st.setFirstName(data);
							else if (index == 2)
								st.setLastName(data);
							else if (index == 3)
								st.setProgramAndPlan(data);
							else if (index == 4)
								st.setAcademicLevel(data);
							else if (index == 5)
								st.setAsurite(data);
							else
								System.out.println("invalid data::" + data);
						index++;

					}
					this.add(st);
					index = 0;
				}
			}
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Iterator getIterator() {
		return studentList.iterator();
	}
}