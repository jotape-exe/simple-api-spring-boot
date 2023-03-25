package com.myapi.example.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
    @Size(min = 2, max = 180)
    @NotBlank
    private String name;
    @Column(name = "registration")
    @Size(max = 10)
    @NotBlank
    private String registration;
    @Column(name = "course")
    @Size(min = 3, max = 255)
    @NotBlank
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
