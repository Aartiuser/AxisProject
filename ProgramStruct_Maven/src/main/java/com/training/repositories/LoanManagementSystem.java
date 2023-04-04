package com.training.repositories;


import com.training.entities.Loan;
import com.training.entities.Student;
import com.training.util.DBCon;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class LoanManagementSystem {
    public int viewLoanCountBasedOnType (String loanType){
        int count=0;
        try{                                                                                //Database
            String query = "SELECT count(*) FROM Loan where loanType=?";
            PreparedStatement pstmt = DBCon.con.prepareStatement(query);
            pstmt.setString(1, loanType);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            count=rs.getInt(1);

        }catch(SQLException se){
            throw new RuntimeException(se);
        }
        return count;
    }
}
