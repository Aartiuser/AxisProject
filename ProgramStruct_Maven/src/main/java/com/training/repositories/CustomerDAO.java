package com.training.repositories;

import com.training.entities.Customer;
import com.training.entities.Student;
import com.training.util.DBCon;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomerDAO {
    public ArrayList<Customer> getAll(){
        ArrayList<Customer> clist=new ArrayList<>();
        Customer c;
        try{                                                                                //Database
            Statement st= DBCon.con.createStatement();
            ResultSet rs=st.executeQuery("select * from Customer");
            while(rs.next()){
                c=new Customer();                                                  //Creating new Student object
                c.setName(rs.getString(1)); ;
                c.setEmail(rs.getString(2));
                c.setPhoneNo(rs.getLong(3));
                c.setCity(rs.getString(4));
                c.setCust_id(rs.getInt(5));
                clist.add(c);                                                             //Adding details into arrayList
            }
        }catch(SQLException se){
            throw new RuntimeException(se);
        }
        return clist;                                                               //Returning arrayList
    }
    public int update(Customer c){
        int count=0;
        try{
            String query = "update Customer set Name=?,email=?,phoneNo=?,city=?  where Cust_id= ?";
            PreparedStatement pstmt = DBCon.con.prepareStatement(query);
            pstmt.setString(1, c.getName());
            pstmt.setString(2, c.getEmail());
            pstmt.setLong(3,c.getPhoneNo());
            pstmt.setString(4, c.getCity());
            pstmt.setInt(5, c.getCust_id());
             count = pstmt.executeUpdate();
        }catch(SQLException se){
            throw new RuntimeException(se);
        }
        return count;
    }
    public int ins(Customer c){
        int count;
        try{
            String query = "insert into Customer (Name,email,phoneNo,city,Cust_id) values (?,?,?,?,?)";
            PreparedStatement pstmt = DBCon.con.prepareStatement(query);
            pstmt.setString(1, c.getName());
            pstmt.setString(2, c.getEmail());
            pstmt.setLong(3,c.getPhoneNo());
            pstmt.setString(4, c.getCity());
            pstmt.setInt(5, c.getCust_id());
            count = pstmt.executeUpdate();
        }catch(SQLException se){
            throw new RuntimeException(se);
        }
        return count;
    }
    public int delById(int ID){
        int count=0;
        try{                                                                                //Database
            String query = "delete from Customer where Cust_id= ?";
            PreparedStatement pstmt = DBCon.con.prepareStatement(query);
            pstmt.setInt(1,ID);
             count = pstmt.executeUpdate();
        }catch(SQLException se){
            throw new RuntimeException(se);
        }
        return count;
    }
}
