package com.myapi.example.controller;

import com.myapi.example.model.Discipline;
import com.myapi.example.service.impl.DisciplineServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/disicipline")
public class DisciplineController {

    @Autowired
    private DisciplineServiceImpl disciplineServiceImpl;

    @GetMapping("/{id}")
    public ResponseEntity<Discipline> findById(@PathVariable Long id){
        Discipline discipline = this.disciplineServiceImpl.findById(id);
        return ResponseEntity.ok().body(discipline);
    }
    @GetMapping("/")
    public ResponseEntity<List<Discipline>> findAll(){
        List<Discipline> disciplines = this.disciplineServiceImpl.findAll();
        return ResponseEntity.ok().body(disciplines);
    }

    @PostMapping("/create/")
    public ResponseEntity<Discipline> create(@Valid @RequestBody Discipline discipline){
        this.disciplineServiceImpl.create(discipline);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/id").buildAndExpand(discipline.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Discipline> update(@Valid @RequestBody Discipline discipline, @PathVariable Long id){
        discipline.setId(id);
        discipline = this.disciplineServiceImpl.update(discipline);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) throws RuntimeException{
        this.disciplineServiceImpl.delete(id);
        return ResponseEntity.noContent().build();
    }
}
