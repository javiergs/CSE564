/**
 * Time taken to implement ~ 1.5 hours.
 * 
 * @author Nitish Tripathi
 *
 */

abstract class Decorator102 extends Decorator102Student {
	protected Decorator102Student student;
	
	public void add(Decorator102Student student) {
		this.student = student;
	}
	
	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return this.student.getInfo();
	}

	
	@Override
	public String getAsurite() {
		return this.student.getAsurite();
	}
}
