import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/**
 *
 * @author Arunima Mookherjee
 * time taken : 5 hours
 * @version 1.0
 */

public class Grader73 {

    public int gradeStudents(StudentRepository71 repo,String filePath) {
        BufferedReader br = null;
        String nextLine = null;
        List<String> columns = new ArrayList<>();
        Map<String, String> gradeMap = new HashMap<>();
        try {
            br = new BufferedReader(new FileReader(filePath));
            if ((nextLine = br.readLine()) != null && nextLine.contains(",")) {
                String[] colNames = nextLine.split(",");
                for(String col : colNames)
                    columns.add(col);
            }
            while((nextLine = br.readLine()) != null && nextLine.contains(",")) {
                String[] parts = nextLine.split(",", 2);
                gradeMap.put(parts[0], parts[1]);
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
        	StudentCoreData72 temp = (StudentCoreData72) studentRepo.next();
            //Student72Decorator temp = (Student72Decorator)studentRepo.next();
        	StudentGrades72Decorator gradeDec = null;
            String asurite = temp.getAsurite();
            if(gradeMap.containsKey(asurite))
            {
                String grades = gradeMap.get(asurite);
                String[] gradesSplit = grades.split(",");
                for(int i = 1; i < columns.size(); ++i)
                {
                    //temp.add(new StudentGrades72Decorator(columns.get(i), Integer.parseInt(gradesSplit[i - 1])), 100);
                	gradeDec = new StudentGrades72Decorator(columns.get(i), Integer.parseInt(gradesSplit[i-1]), 100);         
                }
                temp.setGrades(gradeDec.getGrades());   
                StudentGrades72Decorator.grades.clear();
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