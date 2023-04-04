public class MethodOverloading {
    private static int x=0;
    private int y=3;
    public void StaticDemo(){
        x++;
        y+=5;
        System.out.println("The value of X is: "+x+" The value of Y is: "+y);
    }
    public static void add(){
        System.out.println("No parameters used");

    }
    public static void add(int x,int y,int z){
        int sum=x+y+z;
        System.out.println("Value of sum is: "+sum);
    }
    public static void add(int a,int b){
        int sum=a+b;
        System.out.println("Value of sum is: "+sum);
    }
    public static void add(String s1, String s2){
        String sum=s1+s2;
        System.out.println("Value of sum is: "+sum);
    }

    public static void main(String[] args) {
    add();
    add(2,8);
    add("Aarti","Siddharth");
    add(5,8,6);
    MethodOverloading m=new MethodOverloading();
    m.StaticDemo();
    MethodOverloading m1=new MethodOverloading();
    m1.StaticDemo();
    MethodOverloading m2=new MethodOverloading();
    m2.StaticDemo();
    MethodOverloading m3=new MethodOverloading();
    m3.StaticDemo();
    }
}
