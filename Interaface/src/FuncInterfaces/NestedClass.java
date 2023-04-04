package FuncInterfaces;

public class NestedClass {
    int x=10;
    class Inside{                                                       //Inner class
        int y;
        String display(){                                               //method of inner class
            System.out.println(x);
            Print();
            return"Inner class method";
        }

    }
    void Print() {                                                  //method of an outer class
        class inner {                                              //local class inside a method
            String print() {
                return "local class method";

            }
        }
        inner s=new inner();
        System.out.println(s.print());
        Thread t =new Thread(){                                             //local class without name,anonymous
            public void run(){
                System.out.println("new Thread created");
            }};
        t.start();
        new Thread(()->System.out.println("Inside Lamda Thread")).start();
    }

    public static void main(String[] args) {
        NestedClass nest=new NestedClass();

       /*Inside in=new Inside(); //only for static inner class; without instance
        in.display();*/

        Inside in=nest.new Inside(); //non static inner class
        System.out.println(in.display());
    }
}
