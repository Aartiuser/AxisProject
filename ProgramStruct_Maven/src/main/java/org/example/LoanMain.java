package org.example;

import com.training.repositories.LoanManagementSystem;
import com.training.util.DBCon;

import java.sql.SQLException;
import java.util.Scanner;

public class LoanMain {
    public static void main(String[] args) throws SQLException {
        String ans;int count;
        Scanner sc=new Scanner(System.in);
        DBCon.getConnection();
        LoanManagementSystem lms=new LoanManagementSystem();
        do {
            System.out.println("Enter the type of loan to be searched: ");
            count=lms.viewLoanCountBasedOnType(sc.next());
            if(count>0)
                 System.out.println("Number of customers who have taken loan: "+count);
            else
                System.out.println("No customer has acquired loan");
            System.out.println("Do you want to search again? (Yes/No)");
            ans=sc.next();
        }while(ans.equalsIgnoreCase("Yes"));
        System.out.println("Thank you for using the Application");
    }
}
