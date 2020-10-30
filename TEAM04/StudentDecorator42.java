public abstract class StudentDecorator42 implements Student42 {
    protected Student42 decoratedStudent42;

    public StudentDecorator42(Student42 decoratedStudent42){
        this.decoratedStudent42 = decoratedStudent42;
    }

    @Override
    public void add(String date, int minutes) {
        decoratedStudent42.add(date, minutes);
    }

    @Override
    public void add(String assignmentName, int marksObtained, int weightage) {
        decoratedStudent42.add(assignmentName, marksObtained, weightage);
    }

}
