package org.example;

import com.training.entities.Student;
import com.training.repositories.StudentDAO;
import com.training.service.CustomerService;
import com.training.service.StuService;
import com.training.util.DBCon;

import java.sql.SQLException;
import java.util.Scanner;

public class CustMain {
        public static void main(String[] args) throws SQLException {
            Scanner sc=new Scanner(System.in);
            CustomerService obj=new CustomerService();
            DBCon.getConnection();
            char ans;
            do{
                System.out.println("1. Get All Customer Details\n2. Update Customer Details\n3. Insert Customer Detail into table\n4. Delete Customer Details by ID");
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
                }
                System.out.println("Do you want to continue? (Y/N): ");
                ans=sc.next().charAt(0);
            }while(ans=='y'|| ans=='Y');
        }
}

