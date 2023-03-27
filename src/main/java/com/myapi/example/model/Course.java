package com.myapi.example.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Table(name = Course.TABLE_NAME)
@Data
public class Course {
    public static final String  TABLE_NAME = "course";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @NotBlank
    @Size(min = 3, max = 150)
    private String name;

    @Column(name = "workload")
    @NotNull
    @Min(1)
    @Max(40)
    private int workload;
}
