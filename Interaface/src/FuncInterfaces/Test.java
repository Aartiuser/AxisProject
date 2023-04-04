package FuncInterfaces;

public interface Test {
    public static void run(){
        System.out.println("Im Test Interface function");
    }
    public default void disp(){
        System.out.println("Im default function of Test");
    }
}
