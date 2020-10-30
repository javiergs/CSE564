import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Attendance74Decorator {
	
	public int decorateStudentsWithAttendance(StudentRepository71Iterator repo, String filePath) {
        BufferedReader br = null;
        String nextLine = null;
        List<String> columns = new ArrayList<>();
        Map<String, String> attendanceMap = new HashMap<>();
        try {
            br = new BufferedReader(new FileReader(filePath));
            if ((nextLine = br.readLine()) != null && nextLine.contains(",")) {
                String[] colNames = nextLine.split(",");
                for(String col : colNames)
                    columns.add(col);
            }
            while((nextLine = br.readLine()) != null && nextLine.contains(",")) {
                String[] parts = nextLine.split(",", 2);
                attendanceMap.put(parts[0], parts[1]);
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Iterator71 studentRepo = repo.getIterator();
        int unknown = 0;


        while (studentRepo.hasNext())
        {
        	StudentAttendance72Decorator stdDec = null;
        	StudentCoreData72 temp = (StudentCoreData72) studentRepo.next();
            //Student72Decorator temp = (Student72Decorator)studentRepo.next();
            String asurite = temp.getAsurite() + "@asu.edu";
            if(attendanceMap.containsKey(asurite))
            {
                String attendance = attendanceMap.get(asurite);
                String[] attendanceSplit = attendance.split(",");
                for(int i = 1; i < columns.size(); ++i)
                {
                    //temp.add(new StudentGrades72Decorator(columns.get(i), Integer.parseInt(gradesSplit[i - 1])), 100);
                	stdDec= new StudentAttendance72Decorator(columns.get(i), Integer.parseInt(attendanceSplit[i-1]));
                }
                
                temp.setAttendanceList(stdDec.getAttendanceList());
                StudentAttendance72Decorator.attendanceList.clear();
            }
            else
            {
                unknown++;
            }
        }
        repo.objectDecorated();
        return unknown;
    }

}
