import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoadStudents51 {

    private StudentRepository51 repository;
    
    
    public LoadStudents51(StudentRepository51 studentRepository) {
    	this.repository = studentRepository;
	}

    /**
     * Read the roster csv in an infinte loop and checks if there are any changes.
     * if there are changes then uappend the student object list and notify the observers.
     * This is called by main method once the StudentRoster object is created
     *
     * @param  filePath   the path of file to be read
=     */
    public void readRosterCSV(String filePath) {
        List<Student52> students = new ArrayList<>();
        BufferedReader br = null;
        String nextLine = null;
        try {
            br = new BufferedReader(new FileReader(filePath));
            nextLine = br.readLine();
            while ((nextLine = br.readLine()) != null) {
                String[] studentFields = nextLine.split(",");
                if (studentFields.length > 1) {
                	Student52 student = new StudentCoreData52(studentFields[5], studentFields[1] + " " + studentFields[2], studentFields[3], studentFields[4]);
                    students.add(student);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (students.size() > 0)
        	repository.addStudent(students);
    }
}