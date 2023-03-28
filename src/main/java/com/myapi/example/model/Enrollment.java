package com.myapi.example.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = Enrollment.TABLE_NAME)
public class Enrollment {
    public static final String TABLE_NAME = "enrollment";

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false, updatable = false)
    @NotNull
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false, updatable = false)
    @NotNull
    private Course course;

    @Column(name = "date_creation")
    @NotNull
    private Date date_creation;

}
