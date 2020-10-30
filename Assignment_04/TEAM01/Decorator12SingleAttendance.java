package team1.sukhpreet;

/**
 * Class for storing attendance details 
 * for a single date.
 *
 * @author  Sukhpreet Anand
 * @version 1.1
 * @since   10-28-2020
 */

public class Decorator12SingleAttendance {
    private String date;
    private float minutes;

    public Decorator12SingleAttendance(String date, float minutes) {
        this.date = date;
        this.minutes = minutes;
    }

    public float getMinutes() {
        return minutes;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Decorator12SingleGrade{" +
                "Date = '" + date + '\'' +
                ", Minutes present = " + minutes +
                '}';
    }
}