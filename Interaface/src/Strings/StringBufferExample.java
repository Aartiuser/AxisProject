package Strings;

import java.util.Scanner;
import java.util.StringTokenizer;
public class StringBufferExample {
    public static void main(String[] args) {
     StringBuffer s1=new StringBuffer("Student");
        System.out.println(s1.charAt(2));
        System.out.println(s1.append("Trainer"));
        System.out.println(s1.capacity());
        System.out.println(s1.deleteCharAt(4));
        System.out.println(s1.length());
        System.out.println(s1.reverse());

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter value for an array of Strings: ");
        String str[]=new String[5];
        for(int i=0;i<5;i++)
            str[i]=sc.nextLine();
        System.out.println("Array of String is: ");
        for(int i=0;i<5;i++)
            System.out.println(str[i]);
        StringTokenizer st = new StringTokenizer("my name is Aarti"," ");
        while(st.hasMoreTokens()){
            System.out.println(st.nextToken());
        }

    }
}
