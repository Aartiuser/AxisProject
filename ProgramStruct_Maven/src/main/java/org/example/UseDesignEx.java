package org.example;

public class UseFactoryEx {
    public static void main(String[] args) {
        FactoryEx obj=FactoryEx.getResource();
        System.out.println(obj);
        FactoryEx obj1=FactoryEx.getResource();
        System.out.println(obj1);
        FactoryEx obj2=FactoryEx.getResource();
        System.out.println(obj2);
    }

}
