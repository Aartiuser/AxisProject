package FuncInterfaces;

public class InterEx implements Compare,Test{

    @Override
    public void disp() {
        Test.super.disp();
    }

    public static void main(String[] args) {
        InterEx i=new InterEx();
        Compare.run();
        Test.run();
        i.disp();
    }
}


