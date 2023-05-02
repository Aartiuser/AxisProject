package org.example;

public class FactoryEx {
    private  int x;
   // static boolean flag=false;
    static FactoryEx obj;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    private FactoryEx(){

    }
    private FactoryEx(int x) {
        this.x = x;
    }
    public static FactoryEx getResource(){
            obj=new FactoryEx();
        return obj;
    }
}
