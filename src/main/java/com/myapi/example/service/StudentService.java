package com.myapi.example.service;

import com.myapi.example.model.Student;
import com.myapi.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student findById(Long id){
        Optional<Student> ninja = this.studentRepository.findById(id);
        return  ninja.orElseThrow(() -> new RuntimeException(
                "Ninja não encontrado. id -> "+id+" Tipo:"+ Student.class.getName()
        ));
    }

    public ArrayList<Student> findAll(){
        return (ArrayList<Student>) this.studentRepository.findAll();
    }

    @Transactional
    public Student update(Student student){
        Student newStudent = findById(student.getId());
        newStudent.setCourse(student.getCourse());
        return this.studentRepository.save(newStudent);
    }

    @Transactional
    public Student create(Student student){
        student.setId(null);
        return this.studentRepository.save(student);
    }

    public void delete(Long id){
        try {
            this.studentRepository.deleteById(id);
        } catch(RuntimeException ex){
            System.out.println("Estudante não existe!");
        }
    }

}
