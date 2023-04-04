package ExceptionHandling;
class InvalidSalaryException extends Exception{
    public InvalidSalaryException(String message){
        super(message);
    }
}
public class Candidate {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getExpectedSalary() {
        return ExpectedSalary;
    }

    public void setExpectedSalary(double expectedSalary) {
        ExpectedSalary = expectedSalary;
    }

    private String name,gender;
    private double ExpectedSalary;
    static Candidate getCandidateDetails(String name, String gender,double sal)throws InvalidSalaryException{
        if(sal<10000){
            throw new InvalidSalaryException("Registration Failed. Salary cannot be less than 10000.");
        }
        else{
        Candidate c=new Candidate();
        c.setGender(gender);
        c.setName(name);
        c.setExpectedSalary(sal);
        return c;
        }
    }
    public static void main(String[] args) {
        try{
            Candidate c=getCandidateDetails("Jhon","Male",50000);
            System.out.println("Registration Successful!");
        }catch(InvalidSalaryException i){
            System.out.println(i.getMessage());
        }

    }
}
