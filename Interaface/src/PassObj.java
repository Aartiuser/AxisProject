class Test{
    int a,b;
    Test(int i,int j){
        a=i;
        b=j;
    }
    void alterprim(int x,int y){
        x=60;
        y=30;
    }
    void alterobj(Test t){
        t.a=40;
        t.b=20;
    }
}
public class PassObj {
    public static void main(String[] args) {
        Test obj=new Test(100,22);
        System.out.println("object state before calling alterprim method obj,a: "+obj.a+" obj,b: "+obj.b);
        obj.alterprim(obj.a,obj.b);
        System.out.println("object state after calling alterprim method obj,a: "+obj.a+" obj,b: "+obj.b);
        System.out.println("object state before calling alterobj method obj,a: "+obj.a+" obj,b: "+obj.b);
        obj.alterobj(obj);
        System.out.println("object state after calling alterobj method obj,a: "+obj.a+" obj,b: "+obj.b);

    }
}
