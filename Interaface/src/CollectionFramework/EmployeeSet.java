package CollectionFramework;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class EmployeeSet {
    public Set<Employee> createSet(){
        EmployeeObj ob=new EmployeeObj();
        String dep1=ob.Emp[0].getDept();
        Set<Employee> empset1=new LinkedHashSet<Employee>();
        empset1.add(ob.Emp[0]);
        empset1.add(ob.Emp[4]);
        return empset1;
    }
   /* EmployeeObj ob=new EmployeeObj();
    String dep1=ob.Emp[0].getDept();
    Set<Employee> empset1=new LinkedHashSet<Employee>();
        empset1.add(ob.Emp[0]);
        empset1.add(ob.Emp[4]);
    String dep2=ob.Emp[1].getDept();
    Set<Employee> empset2=new LinkedHashSet<Employee>();
        empset2.add(ob.Emp[1]);
        empset2.add(ob.Emp[3]);
    String dep3=ob.Emp[2].getDept();
    Set<Employee> empset3=new LinkedHashSet<Employee>();
        empset3.add(ob.Emp[2]);
        empset3.add(ob.Emp[5]);*/
    public static void main(String[] args) {
        EmployeeSet s=new EmployeeSet();
        Set<Employee> empset= new HashSet<Employee>();
        EmployeeObj ob=new EmployeeObj();
        for(int i=0;i<ob.Emp.length;i++){
            empset.add(ob.Emp[i]);
        }
        System.out.println("Elements of Student list are: ");
        for(Employee e:empset){
            System.out.println(e);
        }
       // System.out.println("The Employee details who has more salary is: "+s.MoreSal(empset));

    }
}
