package com.myapi.example.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table(name = Discipline.TABLE_NAME)
public class Discipline {
    public static final String  TABLE_NAME = "discipline";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @NotBlank
    @Size(min = 3, max = 150)
    private String name;

    @Column(name = "workload")
    @NotBlank
    private int workload;
}
