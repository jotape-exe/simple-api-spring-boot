package com.myapi.example.controller;

import com.myapi.example.model.Ninja;
import com.myapi.example.service.NinjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/ninja")
public class NinjaController {

    @Autowired
    private NinjaService ninjaService;

    @GetMapping("/{id}")
    public ResponseEntity<Ninja> findById(@PathVariable Long id){
        Ninja ninja = this.ninjaService.findById(id);
        return ResponseEntity.ok().body(ninja);
    }

    @GetMapping("/")
    public ResponseEntity<List<Ninja>> findAll(){
        List<Ninja> ninjas = this.ninjaService.findAll();
        return ResponseEntity.ok().body(ninjas);
    }


    @PostMapping("/")
    public ResponseEntity<Void> create(@RequestBody Ninja ninja){
        this.ninjaService.create(ninja);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/id").buildAndExpand(ninja.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody Ninja ninja, @PathVariable Long id){
        ninja.setId(id);
        ninja = this.ninjaService.update(ninja);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.ninjaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
