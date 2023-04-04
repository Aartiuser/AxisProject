package CollectionFramework;

import java.util.*;

public class Maps {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<Integer, String>();

        //Adding elements into map
        map.put(2, "Boy");
        map.put(3, "Cat");
        map.put(1, "Aeroplane");
        map.put(5, "Elephant");
        map.put(6, "Fan");
        map.put(6, "Fellow");
        map.put(7, null);

        //Displaying elements of Map
        Set<Integer> keys = map.keySet();
        Iterator it = keys.iterator();
        while (it.hasNext()) {
            System.out.print(map.get(it.next()) + " ");
        }
        System.out.println("\nElement present in key 6:" + map.get(6));
        System.out.println("Does map contains any value 'Boy'? " + map.containsValue("Boy"));
        System.out.println("Does map contains any key 7 " + map.containsKey(7));
        System.out.println("Hashcode of map is: " + map.hashCode());
        System.out.println("" + map.getOrDefault(7, "Gun"));
        System.out.println("Size of map is: " + map.size());


        map.remove(5);
        System.out.println("\nAfter removing element at key 5: ");
        for (int k : map.keySet()) {
            System.out.print(map.get(k) + " ");
        }
        map.remove(3, "Cat");
        System.out.println("\nAfter removing element at key 3 with value Cat: ");
        for (int k : map.keySet()) {
            System.out.print(map.get(k) + " ");
        }
        map.replace(2, "Boy", "Bat");
        System.out.println("\nAfter replacing the value Boy with Bat:");
        for (int k : map.keySet()) {
            System.out.print(map.get(k) + " ");
        }
        map.replace(6, "Following");
        System.out.println("\nAfter replacing the value at key 6 with Following:");
        System.out.print(map.values());

        System.out.println("\nIs map empty ? " + map.isEmpty());
        System.out.println("Size of map is: " + map.size());

        //HASH TABLE

        Map<Character, String> tab = new Hashtable<Character, String>();

        //Adding elements into tab
        tab.put('A', "Animal");
        tab.put('B', "Ball");
        tab.put('D', "Dog");
        tab.put('N', "Name");
        //tab.put('M',null);

        //Displaying elements of Table
        Set<Character> idx = tab.keySet();
        Iterator i = idx.iterator();
        while (i.hasNext()) {
            System.out.print(tab.get(i.next()) + " ");
        }
        System.out.println("\nElement present in key 'D':" + tab.get('D'));
        System.out.println("Does map contains any value 'Ball'? " + tab.containsValue("Ball"));
        System.out.println("Does map contains any key M " + tab.containsKey('M'));
        System.out.println("Hashcode of tap is: " + tab.hashCode());
        System.out.println("Default value for key C: " + map.getOrDefault('C', "Camel"));
        System.out.println("Size of tab is: " + tab.size());

        tab.remove('D');
        System.out.println("\nAfter removing element at key D: ");
        for (char k : tab.keySet()) {
            System.out.print(tab.get(k) + " ");
        }
        tab.remove('B', "Ball");
        System.out.println("\nAfter removing element at key B with value Ball: ");
        for (char k : tab.keySet()) {
            System.out.print(tab.get(k) + " ");
        }
        tab.replace('N', "Name", "Nest");
        System.out.println("\nAfter replacing the value Name with Nest:");
        for (char k : tab.keySet()) {
            System.out.print(tab.get(k) + " ");
        }
        tab.replace('A', "Aerosapace");
        System.out.println("\nAfter replacing the value at key A with Aerospace:");
        System.out.print(tab.values());
        System.out.println("\nIs tab empty ? " + tab.isEmpty());
        System.out.println("Size of tab is: " + tab.size());


        //TREE MAP

        Map<String, String> tree = new TreeMap<String, String>();

        //Adding values in tree

        tree.put("Name","Aarti");
        tree.put("Class","Bsc");
        tree.put("Section","Sem1");
        tree.put("Place",null);
        Set<String> ind = tree.keySet();
        Iterator itr = ind.iterator();
        while (itr.hasNext()) {
            System.out.print(tree.get(itr.next()) + " ");
        }
    }


}

