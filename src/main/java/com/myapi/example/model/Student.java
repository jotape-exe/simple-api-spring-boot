package com.myapi.example.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = Student.TABLE_NAME)
@Data
public class Student {
    public static final String  TABLE_NAME = "student";
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    @Size(min = 2, max = 180)
    @NotBlank(message = "Blank Name!")
    private String name;

    @Column(name = "phone")
    @Size(max = 25)
    private String phone;

    @OneToMany(mappedBy = "student")
    private List<Enrollment> enrollments = new ArrayList<>();

 }
