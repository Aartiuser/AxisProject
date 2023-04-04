package com.training.entities;

public class Customer {
    String Name;
    String email;
    long phoneNo;
    String City;
    int Cust_id;
    public  Customer(){

    }
    public Customer(String name, String email, long phoneNo, String city, int cust_id) {
        Name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        City = city;
        Cust_id = cust_id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(long phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public int getCust_id() {
        return Cust_id;
    }

    public void setCust_id(int cust_id) {
        Cust_id = cust_id;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "Name='" + Name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNo=" + phoneNo +
                ", City='" + City + '\'' +
                ", Cust_id=" + Cust_id +
                '}';
    }
}
