package Streams;

import java.io.Serializable;

public class Employee implements Serializable {
    long employeeId,salary;
    String employeeName;

    //double basicSalary,specialAllowance=250.80,HRA=1000.50;
    Employee(long id,String name,long sal){
        this.employeeId=id;
        this.employeeName=name;
        this.salary=sal;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", salary=" + salary +
                ", employeeName='" + employeeName + '\'' +
                '}';
    }
}
