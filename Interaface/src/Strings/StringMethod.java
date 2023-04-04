package Strings;

public class StringMethod {
    public static void main(String[] args) {
        String name= "Aarti";
        String name1="Siddharth";
        String name3="aarti";
        System.out.println("Name: " +name);
        System.out.println("Name1: "+name1);
        System.out.println("Third character of Name: "+name.charAt(2));
        System.out.println("Aarti compared to Siddharth: "+name.compareTo(name1));
        System.out.println("Aarti compared to aarti: "+name.compareTo(name3));
        System.out.println("is Aarti equal to aarti? " +name.equals(name3));
        System.out.println("Length of Siddharth: "+name1.length());
        System.out.println("Replace i with y: "+name1.replace('i','y') );
        System.out.println("Name1: "+name1);
        int index=name.indexOf('r');
        System.out.println("Index of 'r' in Name: "+index);
        System.out.println("Substring of Aarti: " +name.substring(0,3));

    }
}
