package CollectionFramework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Comparator;

public class StudentList {
    public static void main(String[] args) {
        String name;
        Scanner sc=new Scanner(System.in);
        StudentList st=new StudentList();
        List<Student> list=new ArrayList<Student>();


        //Adding student object to list
        StudentObj ob=new StudentObj();
        for(int i=0;i<ob.stu.length;i++)
            list.add(ob.stu[i]);



        //Displaying via for loop:
        System.out.println("Elements of Student list are: ");
        for(Student s:list){
            System.out.println(s);
        }
        /*System.out.println("After changing list to array: ");
        Object[] arr=list.toArray();

        //Displaying array elements:
        for(int i=0;i<4;i++)
            System.out.print(arr[i]+" , ");*/

        System.out.println("\nEnter the name of student you want to find: ");
        name=sc.nextLine();
        if (st.search(name,list)!=null)
            System.out.println("\nDetails of Student: "+st.search(name,list).toString());
        else
            System.out.println("Not found");

        System.out.println("After sorting the list by name: ");
        list.sort(Comparator.comparing(Student::getStuname));
        //Displaying via Iterator:
        Iterator it=list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println("After sorting the list by Rno: ");
        list.sort(Comparator.comparing(Student::getRno));
        //Displaying via Iterator:
        Iterator itr=list.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
        /*System.out.println("Does the student list has any student object s3: "+list.contains());
        System.out.println("Size of  student List: "+list.size());
        System.out.println("Index of student object s2: "+list.indexOf());
        System.out.println("Student detail at an index :3 "+list.get(3));


        Object[] arr=list.toArray();

        //Displaying array elements:
        for(int i=0;i<4;i++)
            System.out.print(arr[i]+" , ");


*/
    }
    public Student search(String name,List<Student> arr){
        for(Student st:arr){
            if(st.stuname.equals(name))
                return st;
        }
        return null;
    }
}
