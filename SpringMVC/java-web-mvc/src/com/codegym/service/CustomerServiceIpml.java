package com.codegym.service;

import com.codegym.model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceIpml implements CustomerService {
    private static Map<Integer, Customer> customes;

    static {
        customes = new HashMap<>();
        customes.put(1, new Customer(1,"Linh","16/10/1998","Quảng Trị"));
        customes.put(2, new Customer(2,"Duy","1/1/1998","Huế"));
        customes.put(3, new Customer(3,"Hải","2/3/1989","Quảng Nam"));
        customes.put(4, new Customer(4,"Minh","1/10/1995","Đà Nẵng"));
    }

    @Override

    public List<Customer> findAll() {
        return new ArrayList<>(customes.values());
    }

    @Override
    public void save(Customer customer) {
        customes.put(customer.getId(), customer);
    }

    @Override
    public Customer findById(int id) {
        return customes.get(id);
    }

    @Override
    public void update(int id, Customer customer) {
        customes.put(id,customer);
    }

    @Override
    public void remove(int id) {
        customes.remove(id);
    }
}
