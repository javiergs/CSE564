/*
* @Author : Alok Singh
* Team : 91
* Student id:1217108490
*
* */

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;

public class Student91Observable extends Observable {
   //Changed below line as per where the file is
    String csvFile = "/Users/aloksingh/Downloads/roster-x.csv";

    List<Student92Model> list = new ArrayList<Student92Model>();
    Student92CoreData student;
    private static Student91Observable instance = null;

    public void setStudents(List<Student92Model> list) {
        this.list = list;
    }

 //Added
    public void add(Student92Model student92Model){
        setChanged();
        notifyObservers(student92Model);
    }

    public static Student91Observable getInstance()
    {
        if (Student91Observable.instance == null)
        {
            Student91Observable.instance = new Student91Observable();
        }

        return Student91Observable.instance;
    }


    private Student91Observable(){
        //making this class as singleton
    }


    public void init_Iterator(String csvFile){

        String line ="";
        String cvsSplitBy = ",";
      try {

          BufferedReader br = new BufferedReader(new FileReader(csvFile));
          int i = 0;
            while ((line = br.readLine()) != null)
            {   i++;

                String[] details = line.split(cvsSplitBy);

                if(i > 2)
                {
                    student = new Student92CoreData(details[0],details[1],details[2],details[3],details[4],details[5]);
                    list.add(student);
                    setChanged();
                    notifyObservers(student);
                }

            }

        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
          e.printStackTrace();
      }
    }

    public Iterator getIterator() {
        return new StudentIterator();
    }
    private class StudentIterator implements Iterator
    {

        int index;

        public boolean hasNext() {

            if(index < list.size()){
                return true;
            }
            return false;
        }

        public Object next() {

            if(this.hasNext())
            {
                return list.get(index++);
            }
            return null;
        }

        public void remove() {
                // empty as no need in this project
        }
    }

}
