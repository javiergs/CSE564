/*
 * @Author : Swarnalatha Srenigarajan
 * Team : 94
 * ASUid: 1217035534
 
 * */


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Reporter94 {

    public int studentAttendance(String filePath) {
       BufferedReader br = null;
        String nextLine = null;
        List<String> columns = new ArrayList<>();
        Map<String, String> attendanceMap = new HashMap<>();
        try {
            br = new BufferedReader(new FileReader(filePath));
            if ((nextLine = br.readLine()) != null) {
                String[] colNames = nextLine.split(",");
                for(String colName : colNames)
                    columns.add(colName);
            }
            while((nextLine = br.readLine()) != null) {
                String[] parts = nextLine.split(",", 2);
                attendanceMap.put(parts[0], parts[1]);
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Student91Observable studentRepo = Student91Observable.getInstance();
        int unknown = 0;
        //Added
        List<Attendance92Decorator> attendanceLst = new ArrayList<>();

        for(Iterator<?> iter = studentRepo.getIterator(); iter.hasNext();) {
            Student92Model student = (Student92CoreData) iter.next();
            //Added
            Attendance92Decorator gstudent = new Attendance92Decorator(student);
            //student = new Attendance92Decorator(student);
            String attendanceCard = attendanceMap.get(student.getStudentAsurite());
            if(attendanceCard != null) {
                List<Attendance92Model> attendanceList = new ArrayList<>();
                String[] attendance = attendanceCard.split(",");
                for(int i = 0; i < attendance.length; i++) {
                    Attendance92Model attendanceObj = new Attendance92Model();
                    //Added
                    attendanceObj.setDate(columns.get(i + 1));
                    attendanceObj.setMinutes(attendance[i]);
                    //
                    attendanceList.add(attendanceObj);
                }
                gstudent.add(attendanceList);
                //
                attendanceLst.add(gstudent);
            }
            else
                unknown++;
        }
        //
        for(Attendance92Decorator a:attendanceLst){
            studentRepo.add(a);
        }
        return unknown;
    }

}
