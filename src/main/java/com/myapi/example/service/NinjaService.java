package com.myapi.example.service;

import com.myapi.example.model.Ninja;
import com.myapi.example.repository.NinjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class NinjaService {
    @Autowired
    private NinjaRepository ninjaRepository;

    public Ninja findById(Long id){
        Optional<Ninja> ninja = this.ninjaRepository.findById(id);
        return  ninja.orElseThrow(() -> new RuntimeException(
                "Ninja não encontrado. id -> "+id+" Tipo:"+Ninja.class.getName()
        ));
    }

    public ArrayList<Ninja> findAll(){
        return (ArrayList<Ninja>) this.ninjaRepository.findAll();
    }

    public Ninja update(Ninja ninja){
        Ninja newNinja = findById(ninja.getId());
        newNinja.setElement(ninja.getElement());
        newNinja.setVillage(ninja.getVillage());
        newNinja.setName(ninja.getName());
        return this.ninjaRepository.save(newNinja);
    }

    public Ninja create(Ninja ninja){
        ninja.setId(null);
        return this.ninjaRepository.save(ninja);
    }

    public void delete(Long id){
        try {
            this.ninjaRepository.deleteById(id);
        } catch(NullPointerException ex){
            System.out.println("Ninja não existe");
        }
    }

}
