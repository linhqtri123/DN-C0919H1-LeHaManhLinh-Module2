package com.example.quanlykhachhangsudungrestful.repository;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface Repository<T> {
    List<T> findAll();

    T findById(Long id);

    void save(T model);

    void remove(Long id);

}
