package team1.sukhpreet;

/**
 * Class for storing grade details of a single
 * assignment or quiz.
 *
 * @author  Sukhpreet Anand
 * @version 1.1
 * @since   10-28-2020
 */

public class Decorator12SingleGrade {
    private String assignmentName;
    private float grade;

    public Decorator12SingleGrade(String assignmentName, float grade) {
        this.assignmentName = assignmentName;
        this.grade = grade;
    }

    public float getGrade() {
        return grade;
    }

    public String getAssignmentName() {
        return assignmentName;
    }

    @Override
    public String toString() {
        return "Decorator12SingleGrade{" +
                "assignmentName='" + assignmentName + '\'' +
                ", grade=" + grade +
                '}';
    }
}