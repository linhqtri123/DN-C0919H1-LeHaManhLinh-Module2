package com.example.quanlytinh.service;

import com.example.quanlytinh.models.Customer;
import com.example.quanlytinh.models.Province;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {
    Iterable<Customer> findAll();

    Customer findById(Long id);

    void save(Customer customer);

    void remove(Long id);

    Iterable<Customer> findAllByProvince(Province province);
}
