package com.myapi.example.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;

@Entity
@Table(name = "ninjas")
@Data
public class Ninja {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "element")
    private ArrayList<String> element;
    @Column(name = "village")
    private String village;

    public Ninja(Long id, String name, ArrayList<String> element, String village) {
        this.id = id;
        this.name = name;
        this.element = element;
        this.village = village;
    }
    public Ninja(){
        
    }
}
