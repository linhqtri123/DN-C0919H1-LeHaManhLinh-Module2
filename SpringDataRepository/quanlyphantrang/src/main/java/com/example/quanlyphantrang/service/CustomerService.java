package com.example.quanlyphantrang.service;

import com.example.quanlyphantrang.models.Customer;
import com.example.quanlyphantrang.models.Province;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {

    Page<Customer> findAllByFirstNameContaining(String firstname, Pageable pageable);

    Page<Customer> findAll(Pageable pageable);

    Customer findById(Long id);

    void save(Customer customer);

    void remove(Long id);

    Iterable<Customer> findAllByProvince(Province province);
}
