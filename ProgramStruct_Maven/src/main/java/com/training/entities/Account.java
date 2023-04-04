package com.training.entities;

import java.util.Date;

public class Account {
    String accHolderName;
    String Branch;
    int accId;
    Date date;
    String AccType;
    int cust_id;
    double bal;
    double Interest;
    public void  calInt(){
        Interest=0.0;
    }
    public Account(){

    }
    public Account(String accHolderName, String branch, int accId, Date date, String accType,int custid) {
        this.accHolderName = accHolderName;
        Branch = branch;
        this.accId = accId;
        this.date = date;
        AccType = accType;
        cust_id=custid;
        //bal=bal;
    }

    public int getCust_id() {
        return cust_id;
    }

    public void setCust_id(int cust_id) {
        this.cust_id = cust_id;
    }

    public String getAccHolderName() {
        return accHolderName;
    }

    public void setAccHolderName(String accHolderName) {
        this.accHolderName = accHolderName;
    }

    public String getBranch() {
        return Branch;
    }

    public void setBranch(String branch) {
        Branch = branch;
    }

    public int getAccId() {
        return accId;
    }

    public void setAccId(int accId) {
        this.accId = accId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAccType() {
        return AccType;
    }

    public void setAccType(String accType) {
        AccType = accType;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accHolderName='" + accHolderName + '\'' +
                ", Branch='" + Branch + '\'' +
                ", accId=" + accId +
                ", date=" + date +
                ", AccType='" + AccType + '\'' +
                ", cust_id=" + cust_id +
                '}';
    }
}
class FixedAccount extends Account{
    public void calInt(){
    }
}
class SavingsAccount extends Account{

    public void calInt(){
    }

}