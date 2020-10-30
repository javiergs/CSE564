/*
Author: Ria Mehta
File Version: 1.2
Time required: 5 hours
Description: Driver class for the project. Project starts and ends here. Iterator71 Pattern is implemented.
Output: Student71 Information
*/
public class Main71 {

    public static void main(String[] args) {

//        Student71 ria= new Student71("roster-x.csv");
        StudentRepository71Iterator studentRepository71 = new StudentRepository71Iterator();
        studentRepository71.initStudentRepository71("roster-x.csv");

//        StudentSubject71 studentSubject71 = new StudentSubject71();
        for(Iterator71 iter = studentRepository71.getIterator(); iter.hasNext();){
            Student71 student71 = (Student71)iter.next();
            System.out.println("ID: "+ student71.getId());
            System.out.println("Name: " + student71.getFirst_name()+ " "+ student71.getLast_name());
            System.out.println("Program and Plan: " + student71.getProgramPlan());
            System.out.println("Academic Level: " + student71.getAcademic_level());
            System.out.println("Asurite: " + student71.getAsurite());
        }

        //Observer71 Pattern
        //An example of adding a new student
        Student71 newStudent71 = new StudentCoreData72("1230321,Ria,Mehta,Software Engineering MS,Graduate,rnmehta1");
        //studentSubject71.setState(1);  //Add student
        studentRepository71.addStudent(newStudent71);
        //Print all student71s
        for(Iterator71 iter = studentRepository71.getIterator(); iter.hasNext();){
            Student71 student71 = (Student71)iter.next();
            student71.printValue(); // Different way of Printing all values at once
        }

    }
}

