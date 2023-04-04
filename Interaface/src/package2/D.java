package package2;

import package1.A;

public class D extends A{
    public int add(int x,int y){
        int sum=x+y;
        return sum;
    }
    public static void main(String[] args){
        D obj=new D();

       //  System.out.println("The value of def variable is: "+obj.def); //default is not visible here
        System.out.println("The value of protected variable of is: "+obj.pro); // protected is not visible here
        System.out.println("The value of public variable of is: "+obj.pub);
        //private is not visible here.
        int sum=obj.add(obj.pro,obj.pub);
        System.out.println("The value of sum is: "+sum);
    }
}
