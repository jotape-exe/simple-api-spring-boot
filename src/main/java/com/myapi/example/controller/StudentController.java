package com.myapi.example.controller;

import com.myapi.example.model.Student;
import com.myapi.example.service.impl.StudentServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentServiceImpl studentServiceImpl;

    @GetMapping("/{id}")
    public ResponseEntity<Student> findById(@PathVariable Long id){
        Student student = this.studentServiceImpl.findById(id);
        return ResponseEntity.ok().body(student);
    }

    @GetMapping("/")
    public ResponseEntity<List<Student>> findAll(){
        List<Student> students = this.studentServiceImpl.findAll();
        return ResponseEntity.ok().body(students);
    }


    @PostMapping("/")
    public ResponseEntity<Void> create(@Valid @RequestBody Student student){
        this.studentServiceImpl.create(student);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/id").buildAndExpand(student.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody Student student, @PathVariable Long id){
        student.setId(id);
        student = this.studentServiceImpl.update(student);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) throws RuntimeException{
        this.studentServiceImpl.delete(id);
        return ResponseEntity.noContent().build();
    }
}
