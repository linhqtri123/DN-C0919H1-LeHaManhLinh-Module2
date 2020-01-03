package com.example.quanlytinh.repository;

import com.example.quanlytinh.models.Customer;
import com.example.quanlytinh.models.Province;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
    Iterable<Customer> findAllByProvince(Province province);
}
