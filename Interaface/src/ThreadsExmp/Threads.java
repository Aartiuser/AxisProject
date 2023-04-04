package ThreadsExmp;

public class Threads {
    public static void main(String[] args) throws InterruptedException {
        ThreadDemo thread=new ThreadDemo();
        thread.start();

        ThreadOne t1=new ThreadOne();
        t1.run();
       // thread.join();
        System.out.println("This is main");

    }
}
class ThreadDemo extends Thread{
    synchronized  public void run(){
        for(int i=0;i<10;i++)
        System.out.println(Thread.currentThread().getName()+" "+ i);
        /*try{
            Thread.sleep(100);
        }catch(InterruptedException io){
            io.printStackTrace();
        }*/

    }
}
class ThreadOne implements Runnable{
    synchronized public void run(){
        for(int i=0;i<10;i++)
            System.out.println(Thread.currentThread().getName()+" "+ i);
    }
}
