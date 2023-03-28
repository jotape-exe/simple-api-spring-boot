package com.myapi.example.service;

import com.myapi.example.model.Enrollment;

import java.util.ArrayList;

public interface EnrollmentService {
    Enrollment findById(Long id);

    ArrayList<Enrollment> findAll();

    Enrollment create(Enrollment enrollment);

    void delete(Long id);
}
