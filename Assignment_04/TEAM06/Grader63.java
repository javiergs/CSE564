import java.io.File;
import java.util.*;


public class Grader63{

    private Map <String,List<Decorator62GradeBean>> studentGradesList;

    private Repository61 studentRepository61;

    public Grader63() {
        this.studentRepository61 = Repository61.getInstance();
        this.studentGradesList = new HashMap<>();
    }


    public Repository61 getStudentRepository61() {
        return studentRepository61;
    }

    public void setStudentRepository61(Repository61 studentRepository61) {
        this.studentRepository61 = studentRepository61;
    }



    public Map<String, List<Decorator62GradeBean>> getStudentGradesList() {
        return studentGradesList;
    }

    public void setStudentGradesList(Map<String, List<Decorator62GradeBean>> studentGradesList) {
        this.studentGradesList = studentGradesList;
    }

    public String[] returnAssessmentList(String firstLine){
        return firstLine.split(",");
    }

    public void readFile(String filePath){
        try {
            File gradeFile = new File(filePath);

            Scanner myReader = new Scanner(gradeFile);
            
            String[] AssessmentList = returnAssessmentList(myReader.nextLine());
            
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if(data.length()!= 0){
                    String[] studentGrades = data.split(",");
                    List<Decorator62GradeBean> gList = new ArrayList<>();
                    for (int i = 1; i < studentGrades.length; i++) {
                        Decorator62GradeBean g = new Decorator62GradeBean();
                        g.setAssesmentName(AssessmentList[i]);
                        g.setScore(Integer.parseInt(studentGrades[i]));
                        gList.add(g);
                    }
                    studentGradesList.put(studentGrades[0], gList);
                }
            }
            myReader.close();
        }catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public int decorateRepositoryWithGrades(String filePath ){
        readFile(filePath);
        Iterator<Decorator62StudentInterface> studentRepoIterator = this.studentRepository61.getIterator();
        int unknown =0;
        List<Decorator62StudentInterface> decoratorList = new ArrayList();
        while (studentRepoIterator.hasNext()) {
            Decorator62StudentInterface student = studentRepoIterator.next();
            if (studentGradesList.containsKey(student.getAsurite())) {

                List<Decorator62GradeBean> gradesList = studentGradesList.get(student.getAsurite());
                Decorator62StudentGradesDecorator studentGradesDecorator62 = new Decorator62StudentGradesDecorator(
                        student);

                for (Decorator62GradeBean grade62 : gradesList) {
                    studentGradesDecorator62.addGrade(grade62);
                }

                studentRepoIterator.remove();
                decoratorList.add(studentGradesDecorator62);

            } else {
                unknown += 1;
            }

        }

        for (Decorator62StudentInterface studentGradesDecorator62 : decoratorList) {
            this.studentRepository61.add(studentGradesDecorator62);
        }

        return unknown;
    }