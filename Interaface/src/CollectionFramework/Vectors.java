package CollectionFramework;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class Vectors {
    public static void main(String[] args) {
        Vector<Student> vlist=new Vector<Student>();
        StudentObj obj=new StudentObj();
        for(int i=0;i<obj.stu.length;i++)
            vlist.add(obj.stu[i]);

        //Displaying contents of vlist
        Iterator it=vlist.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println("\nThe capacity of vlist: "+vlist.capacity());
        Vector vec=new Vector();
        vec.add(20);
        vec.add(30);
        vec.add(50);
        vec.add(10);
        vec.add(30);
        vec.add("Pagal");
        //Dsipalying vector
        System.out.println("\n"+vec.toString());
        //at index 3
        System.out.println(vec.get(3));
        //removing ele at indx 4
        vec.remove(4);
        System.out.println(vec.toString());
        System.out.println("The capacity of vec is: "+vec.capacity());
        vec.addElement("Dumbest");
        System.out.println("The size of a vec is: "+vec.size());
        System.out.println("The element at indx 5 is: "+vec.elementAt(5));
        System.out.println("clone of vec "+vec.clone());

    }
}
