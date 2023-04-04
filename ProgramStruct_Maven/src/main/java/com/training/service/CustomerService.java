package com.training.service;

import com.training.entities.Customer;
import com.training.entities.Student;
import com.training.repositories.CustomerDAO;
import com.training.util.DBCon;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class CustomerService {
    Scanner sc=new Scanner(System.in);
    CustomerDAO ob=new CustomerDAO();
    public void update(){
        System.out.println("Enter the CustId to update:");
        int ID=sc.nextInt();
        System.out.println("Enter the following detials to upadate: ");
        System.out.println("Enter Name: ");
        String name=sc.next();
        System.out.println("Enter Phone No: ");
        long phone=sc.nextLong();
        System.out.println("Enter Email: ");
        String email=sc.next();
        System.out.println("Enter City: ");
        String city=sc.next();
        if(name!=null && name.matches("^[aA-zZ]*$") && city!=null && city.matches("[aA-zZ]*$") && email!=null && email.matches("^(.+)@(.+)$")){
            Customer c=new Customer(name,email,phone,city,ID);
            int count=ob.update(c);
            System.out.println(count+" rows affected");
            System.out.println("Updated Records...");
        }
        else
            System.out.println("Validation of input failed please try again!");
    }
    public void ins(){
            System.out.println("Enter the CustId:");
            int ID=sc.nextInt();
            System.out.println("Enter Name: ");
            String name=sc.next();
            System.out.println("Enter Phone No: ");
            long phone=sc.nextLong();
            System.out.println("Enter Email: ");
            String email=sc.next();
            System.out.println("Enter City: ");
            String city=sc.next();
            if(name!=null && name.matches("^[aA-zZ]*$") && city!=null && city.matches("[aA-zZ]*$") && email!=null && email.matches("^(.+)@(.+)$")){
                Customer c=new Customer(name,email,phone,city,ID);
                int count=ob.ins(c);
                System.out.println(count+" rows affected");
                System.out.println("Inserted Records into table...");
            }
            else
                System.out.println("Validation of input failed please try again!");
    }
    public void delByid(){
            System.out.println("Enter the Id to delete:");
            int ID=sc.nextInt();
           int count= ob.delById(ID);
            System.out.println(count+" rows affected");
            System.out.println("Updated Table:\n "+ob.getAll());
    }
    public void getdetails(){
        ArrayList<Customer>list=new ArrayList<>();
        System.out.println("Details of Cutomers ordered by Name:\n ");
        list=ob.getAll();
        list.sort(Comparator.comparing(Customer::getName));
        for(Customer c: list)
            System.out.println(c);
    }
}
