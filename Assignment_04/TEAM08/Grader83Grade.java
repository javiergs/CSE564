/**
 * <h1>Grader83Grade</h1>
 * The Grader83Grade class is the class to represent
 * a student grade.
 * <p>
 * CSE564 - Assignment 4
 * Team 8 - Member 3 (ID 83)
 *
 * @author Kaysi Pilcher (kcacheso)
 * @since 10-26-2020
 */

public class Grader83Grade {
    private String name;
    private double score;

    public Grader83Grade(String name, double score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public double getScore() {
        return score;
    }

    public String toString() {
        return name + "," + score + "\n";
    }
}
