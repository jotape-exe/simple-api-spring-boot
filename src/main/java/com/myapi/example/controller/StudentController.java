package com.myapi.example.controller;

import com.myapi.example.model.Student;
import com.myapi.example.service.StudentService;
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
    private StudentService studentService;

    @GetMapping("/{id}")
    public ResponseEntity<Student> findById(@PathVariable Long id){
        Student student = this.studentService.findById(id);
        return ResponseEntity.ok().body(student);
    }

    @GetMapping("/")
    public ResponseEntity<List<Student>> findAll(){
        List<Student> students = this.studentService.findAll();
        return ResponseEntity.ok().body(students);
    }


    @PostMapping("/")
    public ResponseEntity<Void> create(@RequestBody Student student){
        this.studentService.create(student);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/id").buildAndExpand(student.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody Student student, @PathVariable Long id){
        student.setId(id);
        student = this.studentService.update(student);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.studentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
