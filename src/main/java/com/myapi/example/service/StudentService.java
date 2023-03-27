package com.myapi.example.service;

import com.myapi.example.model.Student;

import java.util.ArrayList;



public interface StudentService {

    Student findById(Long id);

    ArrayList<Student> findAll();

    Student update(Student student);

    Student create(Student student);

    void delete(Long id);


}
