package com.myapi.example.service.impl;

import com.myapi.example.model.Student;
import com.myapi.example.repository.StudentRepository;
import com.myapi.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student findById(Long id){
        Optional<Student> student = this.studentRepository.findById(id);
        return  student.orElseThrow(() -> new RuntimeException(
                "Student not found. id -> "+id
        ));
    }

    @Override
    public ArrayList<Student> findAll(){
        return (ArrayList<Student>) this.studentRepository.findAll();
    }

    @Override
    @Transactional
    public Student update(Student student){
        Student newStudent = findById(student.getId());
        newStudent.setCourse(student.getCourse());
        return this.studentRepository.save(newStudent);
    }

    @Override
    @Transactional
    public Student create(Student student){
        student.setId(null);
        return this.studentRepository.save(student);
    }

    @Override
    public void delete(Long id) throws RuntimeException{
        try{
            this.studentRepository.deleteById(id);
        }catch (Exception ex){
            throw new RuntimeException("Student not found. id -> "+id);
        }

    }
}
