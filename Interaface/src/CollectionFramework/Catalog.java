package CollectionFramework;

import java.util.*;

public class Catalog {
    private Map<String, Set<Employee>> cat;

    Catalog(){
        cat=new HashMap<String,Set<Employee>>();
    }
    Catalog(Map<String,Set<Employee>> emp){
        this.cat=emp;
    }
    public Map<String,Set<Employee>> getCatalog(){
        return cat;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Catalog cat1=new Catalog();
        EmployeeObj ob=new EmployeeObj();
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
        empset3.add(ob.Emp[5]);

        cat1.getCatalog().put(dep1,empset1);
        cat1.getCatalog().put(dep2,empset2);
        cat1.getCatalog().put(dep3,empset3);

        Set<String> ind = cat1.getCatalog().keySet();
       /* for(String s: ind){
            System.out.println("Key: "+s+" Value: "+cat1.getCatalog().get(s));
        }*/
        Iterator itr = ind.iterator();
        while (itr.hasNext()) {
            Object d=itr.next();
            System.out.println("Key: "+d);
            System.out.println ("Values: "+cat1.getCatalog().get(d));
        }
        System.out.println("Enter the employee dept you want to see: ");
        String dep=sc.nextLine();
        System.out.println(cat1.getCatalog().get(dep));
        System.out.println("Enter dept to get the number of employees in that dept: ");
        dep=sc.nextLine();
        System.out.println(cat1.getCatalog().get(dep).size());
    }
}
