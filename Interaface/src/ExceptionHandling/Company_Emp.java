package ExceptionHandling;

class EMP{
    String emp_name;
    int emp_id;
    int salary;
    EMP(){
        emp_name="Raghav";
        emp_id=2501;
    }
}
class Reg_Emp extends EMP{
    Reg_Emp(){
        super.salary=35000;
    }
}
class Contract_Emp extends EMP{
    Contract_Emp(){
        super.salary=25000;
    }
}
public class Company_Emp {
    public static void main(String[] args) {
        EMP e = new EMP();
        EMP e1 = new Reg_Emp();
        EMP e2 = new Contract_Emp();
        Reg_Emp r1 = new Reg_Emp();
        System.out.println(r1.salary);
        Contract_Emp c1 = new Contract_Emp();
        System.out.println(c1.salary);
        try{
            Reg_Emp r = (Reg_Emp) new EMP();
            System.out.println(r.salary);
        }catch(ClassCastException excep){
            System.out.println(excep.getMessage());
        }

        try{
            Contract_Emp c = (Contract_Emp) new EMP();
            System.out.println(c.salary);
        }catch(ClassCastException excep1){
            System.out.println(excep1.getMessage());
        }



    }

}
