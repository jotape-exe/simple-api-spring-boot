package com.myapi.example.service;

import java.util.ArrayList;

public interface GenericService<T> {
    T findById(Long id);

    ArrayList<T> findAll();

    T update(T t);

    T create(T t);

    void delete(Long id);
}
