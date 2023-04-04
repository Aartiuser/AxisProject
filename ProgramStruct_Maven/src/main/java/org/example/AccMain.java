package org.example;

import com.training.service.AccountService;

import com.training.util.DBCon;

import java.sql.SQLException;
import java.util.Scanner;

public class AccMain {
    public static void main(String[] args) throws SQLException {
            Scanner sc=new Scanner(System.in);
            AccountService obj=new AccountService();
            DBCon.getConnection();
            char ans;
            do{
                System.out.println("1. Get All Account Details\n2. Update Account Details\n3. Add Account \n4. Delete Account by ID");
                System.out.println("Enter your choice: ");
                int choice=sc.nextInt();
                switch (choice){
                    case 1: {
                        obj.getdetails();
                        break;
                    }

                    case 2: {
                        obj.update();
                        break;
                    }
                    case 3:{
                        obj.ins();
                        break;
                    }
                    case 4:{
                        obj.delByid();
                        break;
                    }
                    default:System.out.println("Wrong Choice: ");
                }
                System.out.println("Do you want to continue? (Y/N): ");
                ans=sc.next().charAt(0);
            }while(ans=='y'|| ans=='Y');
        }
}

