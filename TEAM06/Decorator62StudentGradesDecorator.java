import java.util.ArrayList;
import java.util.List;

/**
 * It decorates a Decorator62StudentInterface with grades.
 * Provides Setters and Getters to access student's grades.
 * 
 * @author Akhilesh Krishnan (akrish84)
 * @since 10/25/2020
 *
 */
public class Decorator62StudentGradesDecorator extends Decorator62StudentDecorator {

	List<Decorator62GradeBean> gradesList = new ArrayList<Decorator62GradeBean>();

	Decorator62StudentGradesDecorator(Decorator62StudentInterface student) {
		super(student);
	}

	@Override
	public void addGrade(Decorator62GradeBean grade) {
		gradesList.add(grade);
	}

	@Override
	public List<Decorator62GradeBean> getGrades() {
		return gradesList;
	}

}
