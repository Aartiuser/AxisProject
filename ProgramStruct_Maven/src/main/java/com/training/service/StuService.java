package com.training.service;

import com.training.entities.Student;
import com.training.repositories.StudentDAO;

import java.util.Scanner;

public class StuService {
    public void ins() {

        StudentDAO ob=new StudentDAO();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the following detials to Add: ");
        System.out.println("Enter the Id :");
        int ID = sc.nextInt();
        System.out.println("Enter Name: ");
        String name = sc.next();
        System.out.println("Enter Class: ");
        String Class = sc.next();
        if(name!=null && name.matches("^[aA-zZ]*$") && Class!=null && Class.matches("[a-zA-Z0-9]*")){
            Student s=new Student(ID,name,Class);
            int count=ob.ins(s);
            System.out.println(count+" rows affected");
            System.out.println("Inserted records into the table...");
        }
        else
            System.out.println("Validation of input failed please try again!");

    }
}

