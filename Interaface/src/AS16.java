import java.util.Scanner;

public class AS16 {
    public void validate(String code){
        boolean low=false,check=false,up=false;
        char currchar;
        String splchar="@*#";
        if(code.length()>=8){
           for(int i=0;i<code.length();i++){
               currchar=code.charAt(i);
               if(Character.isUpperCase(currchar))
                   up=true;
               if(Character.isLowerCase(currchar))
                   low=true;
               if(splchar.contains(String.valueOf(currchar)))
                   check=true;
           }
           if(up && low && check)
               System.out.println("Security Code Generated successfully!");
           else
               System.out.println("Invalid security code Try again!");
        }
        else
            System.out.println("Invalid security code Try again!");
    }
    public static void main(String[] args) {
        String sec_code; char ans;
        do{
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter your security code: ");
            sec_code=sc.nextLine();
            AS16 ob=new AS16();
            ob.validate(sec_code);
            System.out.println("Do you want to try again? (Y/N) ");
            ans=sc.next().charAt(0);

        }while(ans=='Y'||ans=='y');

    }
}
