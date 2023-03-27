package com.myapi.example.service;

import com.myapi.example.model.Course;
import com.myapi.example.model.Discipline;

import java.util.ArrayList;

public interface CourseService {
    Course findById(Long id);
    ArrayList<Course> findAll();
    Course update(Course course);
    Course create(Course course);
    void delete(Long id);

}
