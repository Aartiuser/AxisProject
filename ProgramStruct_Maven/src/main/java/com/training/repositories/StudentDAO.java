package com.training.repositories;

import com.training.entities.Student;
import com.training.service.StuService;
import com.training.service.StudentService;
import com.training.util.DBCon;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentDAO  {
    Scanner sc=new Scanner(System.in);
   public  ArrayList<Student> getAll(){
        ArrayList<Student> slist=new ArrayList<>();
        Student s;
        try{                                                                                //Database
            Statement st= DBCon.con.createStatement();
            ResultSet rs=st.executeQuery("select * from student");
            while(rs.next()){
                s=new Student();                                                  //Creating new Student object
                s.setRno(rs.getInt(1)); ;
                s.setName(rs.getString(2));
                s.setBranch(rs.getString(3));

                slist.add(s);                                                             //Adding details into arrayList
            }
        }catch(SQLException se){
           throw new RuntimeException(se);
        }
        return slist;                                                               //Returning arrayList
    }
    public Student getById(){
       Student s=null;
       System.out.println("Enter the id to get details: ");
       int ID=sc.nextInt();
        try{                                                                                //Database
            String query = "SELECT * FROM student where Rno= ?";
            PreparedStatement pstmt = DBCon.con.prepareStatement(query);
            pstmt.setInt(1, ID);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                s=new Student();                                                  //Creating new Student object
                s.setRno(rs.getInt(1)); ;
                s.setName(rs.getString(2));
                s.setBranch(rs.getString(3));
            }
        }catch(SQLException se){
            throw new RuntimeException(se);
        }
        return s;
    }
    public void upById(){
        try{                                                                                //Database
            System.out.println("Enter the Id to update:");
            int ID=sc.nextInt();
            System.out.println("Enter the following detials to upadate: ");
            System.out.println("Enter Name: ");
            String name=sc.next();
            System.out.println("Enter Class: ");
            String Class=sc.next();
            String query = "update student set Name=?,class=?  where Rno= ?";
            PreparedStatement pstmt = DBCon.con.prepareStatement(query);
            pstmt.setString(1, name);
            pstmt.setString(2, Class);
            pstmt.setInt(3,ID);
             int count = pstmt.executeUpdate();
             System.out.println(count+" rows affected");
        }catch(SQLException se){
            throw new RuntimeException(se);
        }
    }
    public int ins(Student s){
        int count;
        try{                                                                                //Database
            String query = "insert into student(Rno,Name,Class) values (?,?,?)";
            PreparedStatement pstmt = DBCon.con.prepareStatement(query);
            pstmt.setInt(1,s.getRno());
            pstmt.setString(2,s.getName());
            pstmt.setString(3,s.getBranch());
            count = pstmt.executeUpdate();
        }catch(SQLException se){
            throw new RuntimeException(se);
        }
        return count;
    }
    public void delById(){
        Student s=null;
        try{                                                                                //Database
            System.out.println("Enter the Id to delete:");
            int ID=sc.nextInt();
            String query = "delete from student where Rno= ?";
            PreparedStatement pstmt = DBCon.con.prepareStatement(query);
            pstmt.setInt(1,ID);
            int count = pstmt.executeUpdate();
            System.out.println(count+" rows affected");
            System.out.println("Updated Table:\n "+getAll());
        }catch(SQLException se){
            throw new RuntimeException(se);
        }
    }
}
