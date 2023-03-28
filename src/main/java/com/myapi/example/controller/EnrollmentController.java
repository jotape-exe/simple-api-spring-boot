package com.myapi.example.controller;

import com.myapi.example.model.Enrollment;
import com.myapi.example.service.impl.EnrollmentServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/enrollment")
public class EnrollmentController {

    @Autowired
    private EnrollmentServiceImpl enrollmentService;

    @GetMapping("/{id}")
    private ResponseEntity<Enrollment> findById(@PathVariable Long id){
        Enrollment enrollment = this.enrollmentService.findById(id);
        return ResponseEntity.ok().body(enrollment);
    }

    @GetMapping("/")
    private ResponseEntity<List<Enrollment>> findAll(){
        List<Enrollment> enrollments = this.enrollmentService.findAll();
        return ResponseEntity.ok().body(enrollments);
    }

    @PostMapping("/create/")
    public ResponseEntity<Enrollment> create(@Valid @RequestBody Enrollment enrollment){
        this.enrollmentService.create(enrollment);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/id").buildAndExpand(enrollment.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws DataIntegrityViolationException {
        this.enrollmentService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
