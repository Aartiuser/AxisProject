package CollectionFramework;

import java.util.*;

public class Sets {
    public static void main(String[] args) {
        Set<Integer> hset = new HashSet<Integer>();

        //Adding elements in hashset
        hset.add(20);
        hset.add(50);
        hset.add(100);
        hset.add(15);
        hset.add(10);
        hset.add(15);
        hset.add(79);

        //displaying elements od hashset
        Iterator it = hset.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println("\nThe size of Hash set is: "+hset.size());
        System.out.println("Does set contains element 10? " + hset.contains(10));
        System.out.println("Is hset empty? " + hset.isEmpty());
        System.out.println("HashCode of hset: " + hset.hashCode());
        hset.remove(100);
        System.out.println("After removing element 100 from Hash set: ");
        for (int i : hset
        ) {
            System.out.print(i + " ");
        }
        Set tset = new TreeSet();

        //Adding elements in treeset
       tset.addAll(hset);
        System.out.println("\nTREE SET:\n");

        //displaying elements od treeset
        Iterator i = tset.iterator();
        while (i.hasNext()) {
            System.out.print(i.next() + " ");
        }
        System.out.println("\nDoes set contains element 10? " + tset.contains(10));
        System.out.println("The size of tree set is: "+tset.size());
        System.out.println("Is tset empty? " + tset.isEmpty());
        System.out.println("HashCode of tset: " + tset.hashCode());
        tset.remove(50);
        System.out.println("After removing element 50 from tree set: ");


        //displaying elements after removing one from tree set
        for (Object j : tset) {
            System.out.print(j + " ");
        }
        Set lset = new LinkedHashSet();

        lset.add(100);
        lset.add(79);
        lset.add(42);
        lset.add(56);

        System.out.println("\nLINKED SET:\n");

        //displaying elements od Linkedhashset
        Iterator j = lset.iterator();
        while (j.hasNext()) {
            System.out.print(j.next() + " ");
        }
        lset.addAll(tset);

        System.out.println("\nAfter adding elements from Tset: "+lset);
        System.out.println("The size of linked set is: "+lset.size());
        System.out.println("HashCode of lset: " + lset.hashCode());
        System.out.println("Does lset contains all elements of tset? "+lset.containsAll(tset));
        lset.removeAll(hset);
        System.out.println("\nLinked set after removing contents of hset: "+lset);
        System.out.println("Is linked set empty? "+lset.isEmpty());
        System.out.println("HashCode of lset: " + lset.hashCode());
        lset.retainAll(tset);
        System.out.println("Lset after retaining only tset values "+lset);
    }
}
