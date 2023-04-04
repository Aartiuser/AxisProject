package com.training.service;

import com.training.entities.Student;

import java.util.ArrayList;

public interface StudentService {
    abstract public ArrayList<Student> getAll();
    abstract public Student getById();
    abstract public void upById();
    abstract public void ins();
    abstract public void delById();
}
