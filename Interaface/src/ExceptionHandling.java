import java.util.Scanner;

public class ExceptionHandling {
    public static void main(String[] args) {
        int quotient=0;
        int a,b;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter value for a: ");
        a=sc.nextInt();
        try{
            b=Integer.parseInt(args[0]);
            try{
                quotient=a/b;
            }
            catch(ArithmeticException exception){
                System.out.println("Exception occurred "+exception.getMessage());
            }
        }
        catch(ArrayIndexOutOfBoundsException e2){
            System.out.println("Exception occurred "+e2.getMessage());
        }
        try{
            String st=null;
            System.out.println(st.equals("Hello"));
        }
        catch(NullPointerException excep){
            System.out.println("Exception occurred "+excep.getMessage());
        }
        finally{
            System.out.println("Done!");
        }
    }
}
