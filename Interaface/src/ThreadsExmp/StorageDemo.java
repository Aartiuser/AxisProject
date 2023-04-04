package ThreadsExmp;

class Storage{
    static int  num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
class Counter extends Thread{
    Storage s;
    Counter(Storage str){
        this.s=str;
    }
    synchronized public void run() {

            System.out.println("Counter starts");
            for (int i = 0; i < 10; i++) {
                System.out.println("Count: "+i);
                try {
                    s.setNum(i);
                    Thread.sleep(0);
                } catch (InterruptedException io) {
                    io.printStackTrace();
                }
            }
            System.out.println("Counter finishes");
        }
}
class Printer extends Thread{
    Storage s;
    Printer(Storage str){
        this.s=str;
    }
    synchronized public void run() {

            System.out.println("Printer starts");
            for (int i = 0; i <=10; i++){
                System.out.println("Print: " + s.getNum());
                try {
                    Thread.sleep(0);
                } catch (InterruptedException iop) {
                    iop.printStackTrace();
                }
            }
            System.out.println("Printer finishes");
    }
}
public class StorageDemo{
    public static void main(String[] args) throws InterruptedException {
        Storage str=new Storage();
        Counter count=new Counter(str); Printer print=new Printer(str);

        count.start();
        print.start();
       count.join();
        System.out.println("This is main");

    }
}
