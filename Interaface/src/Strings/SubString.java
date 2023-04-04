package Strings;

import java.util.Scanner;

public class SubString {
    public static void main(String[] args) {
        String str;
        Scanner sc=new Scanner(System.in);
        str=sc.nextLine();
        for(int i=0;i<str.length();i++){
            for(int j=i+1;j<str.length();j++){
                System.out.println(str.substring(i,j));
            }
        }
        for(int i=0;i<str.length();i++) {
            if (str.matches("[a-zA-Z]+"))
                System.out.println("word");
            else if (str.matches("[0-9]+"))
                System.out.println("number");
            else
                System.out.println("alphanumeric");
        }
    }
}

