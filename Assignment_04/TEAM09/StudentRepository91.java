/*
* * @Author : Alok Singh
 * Team : 91
 * Student id:1217108490
* */
import java.util.Iterator;

public class StudentRepository91 {

    public static void main(String[] args) {
        ObserverPlotter96 gph = new ObserverPlotter96();
        Student91Observable namesRepository =  Student91Observable.getInstance();
        namesRepository.addObserver(gph);
        namesRepository.init_Iterator("/Users/aloksingh/Downloads/roster-x.csv");
        for(Iterator iter = namesRepository.getIterator(); iter.hasNext();)
        {
            Student92CoreData  sbj = (Student92CoreData)iter.next();
            System.out.println(" First Name : " + sbj.getFirstName() + ", Last Name : " + sbj.getLastName() + ", Student Id: " + sbj.getStudentID()
                    + ", Level : " + sbj.getStudentAcademicLevel() + ", Program: " + sbj.getStudentProgram() + ", Asurite Id: " + sbj.getStudentAsurite());
        }
    }
}
