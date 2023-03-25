package com.myapi.example.service;

import com.myapi.example.model.Student;
import com.myapi.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;


public interface StudentService {

    Student findById(Long id);

    ArrayList<Student> findAll();

    Student update(Student student);

    Student create(Student student);

    void delete(Long id);


}
