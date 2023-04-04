package package1;

public class B {
    public static void main(String[] args){
        A obj=new A();
        System.out.println("The value of def variable is: "+obj.def);
        System.out.println("Th value of protected variable of is: "+obj.pro);
        System.out.println("Th value of public variable of is: "+obj.pub);
        //private is not visible here.
    }
}
