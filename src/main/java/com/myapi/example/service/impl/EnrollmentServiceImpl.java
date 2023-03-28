package com.myapi.example.service.impl;

import com.myapi.example.model.Course;
import com.myapi.example.model.Enrollment;
import com.myapi.example.model.Student;
import com.myapi.example.repository.EnrollmentRepository;
import com.myapi.example.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {
    @Autowired
    EnrollmentRepository enrollmentRepository;

    @Autowired
    StudentServiceImpl studentService;

    @Autowired
    CourseServiceImpl courseService;

    @Override
    public Enrollment findById(Long id) {
        Optional<Enrollment> enrollment = this.enrollmentRepository.findById(id);
        return enrollment.orElseThrow(() -> new RuntimeException("Enrollment no found! ID -> "+id));
    }

    @Override
    public ArrayList<Enrollment> findAll() {
        return (ArrayList<Enrollment>) this.enrollmentRepository.findAll();
    }

     @Override
    public Enrollment create(Enrollment enrollment) {
         Student student = this.studentService.findById(enrollment.getStudent().getId());
         Course course = this.courseService.findById(enrollment.getCourse().getId());

         enrollment.setId(null);

         enrollment.setCourse(course);
         enrollment.setStudent(student);

        return this.enrollmentRepository.save(enrollment);
    }

    @Override
    public void delete(Long id) {
        try {
            this.enrollmentRepository.deleteById(id);
        } catch (Exception ex){
            throw new DataIntegrityViolationException("Unable to delete as there are related entities!");
        }
    }

}
