package com.training.service;

import com.training.entities.Account;
import com.training.entities.Customer;
import com.training.repositories.AccountDAO;
import com.training.repositories.CustomerDAO;

import java.text.SimpleDateFormat;
import java.util.*;

public class AccountService {
    Scanner sc=new Scanner(System.in);
    AccountDAO ob=new AccountDAO();
    CustomerDAO obj=new CustomerDAO();
    public void update(){
        int count = 0;boolean flag=false;
        ArrayList<Customer> clist = new ArrayList<>();
        clist = obj.getAll();
        System.out.println("Enter the CustID to update:");
        int id = sc.nextInt();
        for (Customer c : clist) {
            if (c.getCust_id() == id)
               flag=true;
        }
        if (flag == true){
            System.out.println("Enter the AccId:");
            int ID = sc.nextInt();
            System.out.println("Enter Name: ");
            String name = sc.next();
            System.out.println("Enter Branch: ");
            String branch = sc.next();
            System.out.println("Enter Account Type: ");
            String acctype = sc.next();
            if (name != null && name.matches("^[aA-zZ]*$") && acctype != null && acctype.matches("[aA-zZ]*$") && branch != null && branch.matches("[aA-zZ]*$")) {
                Account a = new Account(name, branch, ID, new Date(), acctype, id);
                count = ob.ins(a);
                System.out.println(count + " rows affected");
                System.out.println("Updated Records...");
            } else
                System.out.println("Validation of input failed please try again!");
        }
        else
            System.out.println("No such Customer exists");
    }
    public void ins() {
        int count = 0;boolean flag=false;
        ArrayList<Customer> clist = new ArrayList<>();
        clist = obj.getAll();
        System.out.println("Enter the CustID:");
        int id = sc.nextInt();
        for (Customer c : clist) {
            if (c.getCust_id() == id)
                flag = true;
        }
        if(flag==true){
            System.out.println("Enter the AccId:");
            int ID = sc.nextInt();
            System.out.println("Enter Name: ");
            String name = sc.next();
            System.out.println("Enter Branch: ");
            String branch = sc.next();
            System.out.println("Enter Account Type: ");
            String acctype = sc.next();
            if (name != null && name.matches("^[aA-zZ]*$") && acctype != null && acctype.matches("[aA-zZ]*$") && branch != null && branch.matches("[aA-zZ]*$")) {
                Account a = new Account(name, branch, ID, new Date(), acctype, id);
                count = ob.ins(a);
                System.out.println(count + " rows affected");
                System.out.println("Inserted Records into table...");
            } else
                System.out.println("Validation of input failed please try again!");
        }
        else
            System.out.println("No such Customer exists");
    }
    public void delByid(){
        System.out.println("Enter the Id to delete:");
        int ID=sc.nextInt();
        int count= ob.delById(ID);
        System.out.println(count+" rows affected");
        System.out.println("Updated Table:\n "+ob.getAll());
    }
    public void getdetails(){
        ArrayList<Account> list=new ArrayList<>();
        System.out.println("Details of Account ordered by Branch:\n ");
        list=ob.getAll();
        list.sort(Comparator.comparing(Account::getBranch));
        for(Account a: list)
            System.out.println(a);
    }
}
