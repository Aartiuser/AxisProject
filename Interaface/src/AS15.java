import java.util.Scanner;

public class AS15 {
    public void validate(String id){
        String str=id.substring(0,3);
        String std="GBL";
        if(str.equals(std)&& id.charAt(3)=='/' && id.charAt(7)=='/')
                System.out.println("Login Successfull!");
        else
            System.out.println("Incorrect ID");
    }
    public static void main(String[] args) {
        char ans;

        do {
            String ID;
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter Your ID: ");
            ID = sc.nextLine();
            AS15 ob = new AS15();
            ob.validate(ID);
            System.out.println("Do you want to retry?(y/n): ");
            ans=sc.next().charAt(0);
        }while(ans=='y'|| ans=='Y');
    }
}
