package ThreadsExmp;

import CollectionFramework.ArrayLists;
import CollectionFramework.Student;

import java.util.*;

class Employee{
    String name;
    String dept;
    double salary;
    Date doj;
    long exp;

    public Employee(String name, String dept, double salary, Date doj) {
        this.name = name;
        this.dept = dept;
        this.salary = salary;
        this.doj = doj;
        Date dt=new Date();
        long difference_In_Time= dt.getTime() - doj.getTime();
        this.exp = (difference_In_Time / (1000l * 60 * 60 * 24 * 365));
    }

    long getExp(){
        return this.exp;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", salary=" + salary +
                ", doj=" + doj +
                ", exp=" + exp +
                '}';
    }
}

public class EmpExp {

    public static void main(String[] args) {
        Employee Emp[]=new Employee[]{
                new Employee("Ramesh","Mech",35000,new Date(2019,11,4)),
                new Employee("Shivam","CyberSec",55000,new Date(2017,6,5)),
                new Employee("Madhav","Finance",50000,new Date(2011,9,15)),
                new Employee("Reena","Cybersec",41000,new Date(2022,10,17)),
                new Employee("Swetha","Mech",48000,new Date(2020,8,26)),
                new Employee("Gopal","Finance",54000,new Date(2010,7,24)),
                new Employee("Anu","IT",50000,new Date(2018,10,30))
        };

        ArrayList<Employee> Emparr=new ArrayList<Employee>();
        for(int i=0;i<Emp.length;i++)
            Emparr.add(Emp[i]);
        Emparr.sort(Comparator.comparing(Employee::getExp));
       System.out.println("The Employee with highest experience is: "+Emparr.get(Emp.length-1));
    }
}
