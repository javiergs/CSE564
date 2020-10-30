/**
 * @author rohitksingh
 * @version 1.0
 * @Date Modified 10/25/2020
 */
public class Grade92Model {
	public String colName;
	public String score;
	public String total;

	public Grade92Model(String colName, String score, String total) {
		this.colName = colName;
		this.score = score;
		this.total = total;
	}

	@Override
	public String toString() {
		return colName + " " + score + " " + total;
	}
}
