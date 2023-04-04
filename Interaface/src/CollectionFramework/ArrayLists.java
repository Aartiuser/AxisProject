package CollectionFramework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayLists {
    public static void main(String[] args) {
        ArrayList arr=new ArrayList();
        arr.add("Aarti");
        arr.add(10);
        arr.add(1,20);
        arr.add(2,"Small");

        //Display using Tostring
        System.out.println("Elements in the ArrayList: ");
        System.out.println(arr.toString());
        System.out.println("Does array contain an element '20': "+arr.contains(20));

        List<Integer> list=new ArrayList<Integer>();
        list.add(25);
        list.add(35);
        list.add(45);
        //Display Using iterator
        System.out.println("\nElements in the list: ");
        Iterator i= list.iterator();
        while(i.hasNext()){
            System.out.print(i.next()+" ");
        }
        //adding elements from another list.
        arr.addAll(3,list);

        //Display using listiterator
        System.out.println("\n\nAfter appending another list: ");
        Iterator i1=arr.listIterator();
        while(i1.hasNext()){
            System.out.print(i1.next()+" ");
        }

        //checking equality of two lists
        System.out.println("\n\nIs array list equal to list: "+arr.equals(list));

        //Removing all elements of one list from another
        arr.removeAll(list);

        // Display using for-2nd type
        System.out.println("\nAfter removing all elements of another list: ");
        for(Object o:arr){
            System.out.print(o+" ");
        }

        //removing element using idx
        list.remove(2);

        //Display using for-1st type
        System.out.println("\nAfter removing element from idx 3: ");
        for(int j=0;j<arr.size();j++)
            System.out.print(arr.get(j)+" ");
    }
}
