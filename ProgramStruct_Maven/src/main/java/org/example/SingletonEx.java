package org.example;

public class SingletonEx {
    private  int x;
    static boolean flag=false;
    static SingletonEx obj;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    private SingletonEx(){

    }
    private SingletonEx(int x) {
        this.x = x;
    }
    public static SingletonEx getResource(){
        if(flag==false){
            obj=new SingletonEx();
            flag=true;
        }
        return obj;
    }
}
