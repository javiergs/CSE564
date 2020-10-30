package team1.gaurav;

/**
 * gaurav.Repository11 is the repository class which holds the data of Decorator12StudentCoreData type
 * which is also extends Repository11Observable and implements Repository11Container in order to be observed
 * and to generate iterator respectively
 *
 * @author Gaurav Ainapur
 * @version 1.0
 * @since 10-25-2020
 */


import team1.sukhpreet.Decorator12;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class Repository11 extends Observable implements Repository11Container {

    private static Repository11 INSTANCE;
    public Map<String, Decorator12> studentList = new HashMap<>();

    private Repository11() { }

    public static Repository11 getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Repository11();
        }
        return INSTANCE;
    }

    public void updateStudent(String key, Decorator12 newStudent) {
        studentList.put(key, newStudent);
        setChanged();
        notifyObservers();
    }


    public void loadRoster(String filePath) {
        this.studentList = Repository11FileHelper.readCSV(filePath);
        setChanged();
        notifyObservers();
    }

    @Override
    public Repository11Iterator getIterator() {
        return new Repository11StudentIterator(studentList);
    }

}

