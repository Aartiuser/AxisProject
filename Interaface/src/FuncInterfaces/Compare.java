package FuncInterfaces;

public interface Compare {
    public static void run(){
        System.out.println("Hello Im an Compare Interface function");
    }
    public default void disp(){
        System.out.println("Im Default function of Compare");
    }
}

