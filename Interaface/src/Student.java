public class Student {
    int mark1,mark2;
    String studentID;

    public static void main(String[] args) {
        Student s=new Student();
        s.mark1=58;
        s.mark2=40;
        s.studentID="Aa23";
        Resultcalculator res =new Resultcalculator();
        System.out.println("The garde of the student is: "+res.calculateResult(s));
    }
}
class Result{
    String studentID;
    String grade;

    @Override
    public String toString() {
        return "Result{" +
                "studentID='" + studentID + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}
class Resultcalculator{
    public Result calculateResult(Student stu){
        int total=stu.mark1+stu.mark2;
        Result res=new Result();
        res.studentID=stu.studentID;
        if((total/2.0)<60)
            res.grade="Fail";
        else
            res.grade="Pass";
        return res;
    }
}