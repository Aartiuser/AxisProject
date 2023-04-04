public class Employee {
    long employeeId,employeePhone;
    String employeeName,employeeAddress;
    double basicSalary,specialAllowance=250.80,HRA=1000.50;
    Employee(long id,String name,String address,long phone){
        this.employeeId=id;
        this.employeeName=name;
        this.employeeAddress=address;
        this.employeePhone=phone;
    }
    void calculateSalary(){
        double salary =  this.basicSalary + ( this.basicSalary * this.specialAllowance/100) + ( this.basicSalary * HRA/100);
        System.out.println("The salary of "+this.employeeName+" is: "+salary);
    }
    void calculateTransportallowance(){
        double TransportAllowance=10/100.0*(this.basicSalary);
        System.out.println("The TransportAllowance of "+this.employeeName+" is: "+TransportAllowance);
    }
}
class Manager extends Employee{
    Manager(long id,String name,String address,long phone,double salary){
        super(id,name,address,phone);
        super.basicSalary=salary;
    }
    void calculateTransportallowance(){
        double TransportAllowance=15/100.0*super.basicSalary;
        System.out.println("The TransportAllowance of "+super.employeeName+" is: "+TransportAllowance);
    }
}
class Trainee extends Employee{
    Trainee(long id,String name,String address,long phone,double salary){
        super(id,name,address,phone);
        super.basicSalary=salary;
    }

}

