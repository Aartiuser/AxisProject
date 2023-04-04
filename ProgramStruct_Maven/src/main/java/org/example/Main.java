package org.example;

import com.training.entities.Student;
import com.training.repositories.StudentDAO;
import com.training.service.StuService;
import com.training.service.StudentService;
import com.training.util.DBCon;

import java.sql.*;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws SQLException{
        Scanner sc=new Scanner(System.in);
        StudentDAO obj=new StudentDAO();
        StuService ob=new StuService();
        DBCon.getConnection();
        char ans;
        do{
            System.out.println("1. Get All Student Details\n2. Get Student Detail by ID\n3. Update Student Details\n4. Insert Student Detail into table\n5. Delete Student Details by ID");
            System.out.println("Enter your choice: ");
            int choice=sc.nextInt();
            switch (choice){
                case 1: {
                    System.out.println("All Details: ");
                    for(Student s: obj.getAll())
                        System.out.println(s);
                    break;
                }
                case 2: {
                    System.out.println("Student Detail: ");
                    System.out.println(obj.getById());
                    break;
                }
                case 3: {
                    obj.upById();
                    break;
                }
                case 4:{
                    ob.ins();
                    break;
                }
                case 5:{
                    obj.delById();
                    break;
                }
            }
            System.out.println("Do you want to continue? (Y/N): ");
            ans=sc.next().charAt(0);
        }while(ans=='y'|| ans=='Y');
    }
}