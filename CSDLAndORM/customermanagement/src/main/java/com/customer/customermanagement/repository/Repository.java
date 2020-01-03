package com.customer.customermanagement.repository;

import java.util.List;

public interface Repository<T> {
    List<T> getAll();

    T findById(Long id);

    void save(T model);

    void remove(Long id);
}
