package com.myapi.example.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

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

    public Student(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    public Student(){

    }
}
