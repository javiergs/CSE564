package team1;

import team1.aditya.Reporter14;
import team1.gaurav.Repository11;
import team1.isaac.ObserverTable15;
import team1.kings.ObserverPlotter16;
import team1.nagarjun.Grader13;

/**
 * Main17 class for making connections between multiple components of this project
 *
 * @author Shwetank Bhardwaj
 * @version 1.0
 * @since 10-25-2020
 */

public class Main17 {

    public static void main(String[] args) {
        Repository11 repository11 = Repository11.getInstance();
        Grader13 grader13 = new Grader13(repository11);
        Reporter14 reporter14 = new Reporter14(repository11);
        ObserverTable15 observerTable15 = new ObserverTable15(repository11);
        ObserverPlotter16 observerPlotter16 = new ObserverPlotter16(repository11);

        repository11.addObserver(observerTable15);
        repository11.addObserver(observerPlotter16);

        Main17UI main17UI = new Main17UI(observerTable15, observerPlotter16);
        new Main17Controller(repository11, grader13, reporter14, main17UI);
    }

}

