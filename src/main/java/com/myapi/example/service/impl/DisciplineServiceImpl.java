package com.myapi.example.service.impl;

import com.myapi.example.model.Discipline;
import com.myapi.example.repository.DisciplineRepository;
import com.myapi.example.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class DisciplineServiceImpl implements GenericService<Discipline> {

    @Autowired
    private DisciplineRepository disciplineRepository;
    @Override
    public Discipline findById(Long id) {
        Optional<Discipline> discipline = disciplineRepository.findById(id);
        return discipline.orElseThrow(() -> new RuntimeException("Course not found! ID -> "+id));
    }

    @Override
    public ArrayList<Discipline> findAll() {
        return (ArrayList<Discipline>) this.disciplineRepository.findAll();
    }

    @Override
    public Discipline update(Discipline discipline) {
        Discipline newDiscipline = findById(discipline.getId());
        newDiscipline.setName(discipline.getName());
        newDiscipline.setWorkload(discipline.getWorkload());
        return this.disciplineRepository.save(newDiscipline);
    }

    @Override
    public Discipline create(Discipline discipline) {
        discipline.setId(null);
        return this.disciplineRepository.save(discipline);
    }

    @Override
    public void delete(Long id) {
        try {
            this.disciplineRepository.deleteById(id);
        } catch (Exception ex){
            throw new RuntimeException("Discipline not found! ID -> "+id);
        }
    }
}
