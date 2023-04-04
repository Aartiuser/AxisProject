package CollectionFramework;

import java.util.ArrayList;
import java.util.List;

public class EmployeeObj {
    Employee Emp[]=new Employee[]{new Employee("Ramesh","Mech",35000),
    new Employee("Shivam","CyberSec",55000),
    new Employee("Madhav","Finance",50000),
    new Employee("Reena","Cybersec",41000),
    new Employee("Swetha","Mech",48000),
    new Employee("Gopal","Finance",54000),
    new Employee("Anu","IT",50000)};
List<Employee> arr=new ArrayList<Employee>();
public void add(){
    for(int i=0;i<Emp.length;i++)
        arr.add(Emp[i]);
}
}
