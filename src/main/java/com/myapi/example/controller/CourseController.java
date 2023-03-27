package com.myapi.example.controller;

import com.myapi.example.model.Course;
import com.myapi.example.service.impl.CourseServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseServiceImpl courseServiceImpl;

    @GetMapping("/{id}")
    public ResponseEntity<Course> findById(@PathVariable Long id){
        Course course = this.courseServiceImpl.findById(id);
        return ResponseEntity.ok().body(course);
    }

    @GetMapping("/")
    public ResponseEntity<List<Course>> findAll(){
        List<Course> courses = this.courseServiceImpl.findAll();
        return ResponseEntity.ok().body(courses);
    }

    @PostMapping("/create/")
    public ResponseEntity<Void> create(@Valid @RequestBody Course course){
        this.courseServiceImpl.create(course);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/id").buildAndExpand(course.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody Course course,@PathVariable Long id){
        course.setId(id);
        course = this.courseServiceImpl.update(course);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) throws RuntimeException{
        this.courseServiceImpl.delete(id);
        return ResponseEntity.noContent().build();
    }
}
