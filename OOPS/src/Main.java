public class Main {
    public static void main(String[] args) {
        A obj=new A(5);
        A obj1 =new A();
        System.out.println("Value of static variable after Inc: "+obj.method());
        System.out.println("Value of static variable after Dec: "+obj1.method2());
    }
}
class A{
    static int x;
    int y;
    A(){

    }
    A(int x){
        this.x=x;
    }
    int method(){
        x+=2;
        return x;
    }
    int method2(){
        x-=2;
        return x;
    }
}