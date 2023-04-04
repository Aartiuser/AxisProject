package Strings;

public class StringConstructDemo {
    public static void main(String[] args) {
        String s1="Hello World!";
        String s2=new String("HelloWorld!!!");
        char chars[]={'A','E','I','O','U'};
        String s3=new String(chars);
        byte bytes[]={'a','e','i','o','u'};
        String s4=new String(bytes);
        String s5=new String(s2);
        String s6=new String(bytes,1,4);
        String s7=s1;
        System.out.println(s1);//from where
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s5);
        System.out.println(s6);
        System.out.println(s7);
    }
}
