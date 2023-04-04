package com.training.repositories;

import com.training.entities.Account;
import com.training.entities.Customer;
import com.training.util.DBCon;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class AccountDAO {
        public ArrayList<Account> getAll(){
            ArrayList<Account> alist=new ArrayList<>();
            Account a;
            try{                                                                                //Database
                Statement st= DBCon.con.createStatement();
                ResultSet rs=st.executeQuery("select * from Account");
                while(rs.next()){
                    a=new Account();                                                  //Creating new Student object
                    a.setAccHolderName(rs.getString(1)); ;
                    a.setBranch(rs.getString(2));
                    a.setAccId(rs.getInt(3));
                    a.setDate(rs.getDate(4));
                    a.setAccType(rs.getString(5));
                    a.setCust_id(rs.getInt(6));
                    alist.add(a);                                                             //Adding details into arrayList
                }
            }catch(SQLException se){
                throw new RuntimeException(se);
            }
            return alist;                                                               //Returning arrayList
        }
        public int update(Account a){
            int count=0;
            try{
                String dt=new SimpleDateFormat("YYYY/MM/dd").format(a.getDate());
                String query = "update Account set accHolderName=?,Branch=?,DOC=?,accType=?  where accId=?";
                PreparedStatement pstmt = DBCon.con.prepareStatement(query);
                pstmt.setString(1, a.getAccHolderName());
                pstmt.setString(2, a.getBranch());
                pstmt.setString(3, dt);
                pstmt.setString(4, a.getAccType());
                pstmt.setInt(5, a.getAccId());
                pstmt.setInt(5, a.getCust_id());
                count = pstmt.executeUpdate();
            }catch(SQLException se){
                throw new RuntimeException(se);
            }
            return count;
        }
        public int ins(Account a){
            int count;
            try{
                String dt=new SimpleDateFormat("YYYY/MM/dd").format(a.getDate());
                String query = "insert into Account (accHolderName,Branch,DOC,accType,accId,cust_id) values (?,?,?,?,?,?)";
                PreparedStatement pstmt = DBCon.con.prepareStatement(query);
                pstmt.setString(1, a.getAccHolderName());
                pstmt.setString(2, a.getBranch());
                pstmt.setString(3,dt );
                pstmt.setString(4, a.getAccType());
                pstmt.setInt(5, a.getAccId());
                pstmt.setInt(6, a.getCust_id());
                count = pstmt.executeUpdate();
            }catch(SQLException se){
                throw new RuntimeException(se);
            }
            return count;
        }
        public int delById(int ID){
            int count=0;
            try{                                                                                //Database
                String query = "delete from Account where accId= ?";
                PreparedStatement pstmt = DBCon.con.prepareStatement(query);
                pstmt.setInt(1,ID);
                count = pstmt.executeUpdate();
            }catch(SQLException se){
                throw new RuntimeException(se);
            }
            return count;
        }
        //Comment Added
}
