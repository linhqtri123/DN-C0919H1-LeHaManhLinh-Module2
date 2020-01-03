package com.example.quanlykhachhangsudungrestful.service;

import com.example.quanlykhachhangsudungrestful.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    Customer findById(Long id);

    void save(Customer customer);

    void remove(Long id);
}
