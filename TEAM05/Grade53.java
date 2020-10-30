/**
 * A model class to hold grade object
 * @author Chandan Kiragadalu Javaregowda
 * @version 1.0
 * Time taken - 4 hours
 */
public class Grade53 {

    public String title;
    public String percentageObtained;
    public String totalMarksForAssignment;

	public Grade53(String title, String percentageObtained, String totalMarksForAssignment) {
		this.title = title;
		this.percentageObtained = percentageObtained;
		this.totalMarksForAssignment = totalMarksForAssignment;
	}

	public String getTitle() {
        return title;
    }

    public String getPercentageObtained() {
        return percentageObtained;
    }

    public String getTotalMarksForAssignment() {
        return totalMarksForAssignment;
    }

	@Override
	public String toString() {
		return "Grade [title=" + title + ", percentageObtained=" + percentageObtained + ", totalMarksForAssignment="
				+ totalMarksForAssignment + "]";
	}

}
