package com.myapi.example.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "student")
@Data
public class Student {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "registration")
    private String registration;
    @Column(name = "course")
    private String course;

    public Student(Long id, String name, String registration, String course) {
        this.id = id;
        this.name = name;
        this.registration = registration;
        this.course = course;
    }
    public Student(){

    }
}
