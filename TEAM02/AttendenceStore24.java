/**
 * 
 * @author Suryadeep
 * Class to that creats the Attendence
 * object with asuId, attendance data and attendance
 * percentage value.
 */
public class AttendenceStore24 {

    private Decorator22Student asuId;
    private String attendendeData;
    private String attendendeValue;

    public AttendenceStore24(Decorator22Student asu, String dte, String val) {
        this.asuId = asu;
        this.attendendeData = dte;
        this.attendendeValue = val;
    }

    public String getAttendendeData() {
        return attendendeData;
    }

    public String getAttendendeValue() {
        return attendendeValue;
    }

    public Decorator22Student getAsuId() {
        return asuId;
    }
}
