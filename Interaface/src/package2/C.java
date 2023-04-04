package package2;

import package1.A;

public class C {
    public static void main(String[] args){
        A obj=new A();
       // System.out.println("The value of def variable is: "+obj.def); default is not visible here
       // System.out.println("Th value of protected variable of is: "+obj.pro); // protected is not visible here
        System.out.println("Th value of public variable of is: "+obj.pub);
        //private is not visible here.
    }
}
