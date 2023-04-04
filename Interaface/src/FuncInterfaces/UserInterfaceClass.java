package FuncInterfaces;

import java.util.Scanner;

public class UserInterfaceClass {
    static double totFare=0;
     public static CommisionInfo generateCommissionObtained= (Ticket Obj)->
     {
         if(Obj.getClassType().equalsIgnoreCase("1A")|| Obj.getClassType().equalsIgnoreCase("2A")|| Obj.getClassType().equalsIgnoreCase("3A"))
             totFare+=100;
         else if(Obj.getClassType().equalsIgnoreCase("2S"))
             totFare+=60;
         return totFare;
     };

     public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int count;
        double amnt=0;

        System.out.println("Enter number of passengers: ");
        count=sc.nextInt();
        Ticket obj[]=new Ticket[count];
        for(int i=0;i<count;i++){
            obj[i]=new Ticket();
            System.out.println("Details of Passenger "+(i+1)+": ");
            System.out.println("Enter PNR no: ");
            obj[i].setPnrNo(sc.nextLong());
            System.out.println("Enter Passenger Name: ");
            obj[i].setPassengerName(sc.next());
            System.out.println("Enter seat no: ");
            obj[i].setSeatNo(sc.nextInt());
            System.out.println("Enter class Type: ");
            obj[i].setClassType(sc.next());
            System.out.println("Enter Ticket fare: ");
            obj[i].setTicketFare(sc.nextDouble());
            amnt=generateCommissionObtained.calculateCommissionAmount(obj[i]);
        }
        System.out.println("Commission Obtained: "+amnt);
    }
}
