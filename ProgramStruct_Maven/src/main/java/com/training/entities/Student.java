package com.training.entities;

public class Student {
    int Rno;
    String Name;
    String Branch;

   public Student(){

   }
    public Student(int rno, String name, String branch) {
        Rno = rno;
        Name = name;
        Branch=branch;
    }

    public int getRno() {
        return Rno;
    }

    public void setRno(int rno) {
        Rno = rno;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getBranch() {
        return Branch;
    }

    public void setBranch(String branch) {
        Branch = branch;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Rno=" + Rno +
                ", Name='" + Name + '\'' +
                ", Branch='" + Branch + '\'' +
                '}';
    }
}
