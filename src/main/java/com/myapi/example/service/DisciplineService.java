package com.myapi.example.service;

import com.myapi.example.model.Discipline;

import java.util.ArrayList;

public interface DisciplineService {
    Discipline findById(Long id);
    ArrayList<Discipline> findAll();
    Discipline update(Discipline discipline);
    Discipline create(Discipline discipline);
    void delete(Long id);
}
