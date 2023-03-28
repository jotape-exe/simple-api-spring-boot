package com.myapi.example.service.impl;

import com.myapi.example.model.Course;
import com.myapi.example.repository.CourseRepository;
import com.myapi.example.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CourseServiceImpl implements GenericService<Course> {
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course findById(Long id){
        Optional<Course> course = this.courseRepository.findById(id);
        return course.orElseThrow(() -> new RuntimeException("Course not found! ID -> "+id));
    }

    @Override
    public ArrayList<Course> findAll() {
        return (ArrayList<Course>) this.courseRepository.findAll();
    }

    @Transactional
    @Override
    public Course update(Course course) {
        Course newCourse = findById(course.getId());
        newCourse.setName(course.getName());
        newCourse.setWorkload(course.getWorkload());
        return this.courseRepository.save(newCourse);
    }

    @Transactional
    @Override
    public Course create(Course course) {
        course.setId(null);
        return this.courseRepository.save(course);
    }

    @Override
    public void delete(Long id) {
        try {
            courseRepository.deleteById(id);
        } catch (Exception ex){
            throw new RuntimeException("Course not found. ID -> "+id);
        }
    }
}
