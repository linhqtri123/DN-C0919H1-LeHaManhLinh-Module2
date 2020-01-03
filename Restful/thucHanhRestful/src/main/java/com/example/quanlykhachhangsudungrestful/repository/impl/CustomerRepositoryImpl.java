package com.example.quanlykhachhangsudungrestful.repository.impl;

import com.example.quanlykhachhangsudungrestful.model.Customer;
import com.example.quanlykhachhangsudungrestful.repository.CustomerRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Transactional
@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Customer> findAll() {
        TypedQuery<Customer> query = entityManager.createQuery("select c from Customer c", Customer.class);
        return query.getResultList();
    }

    @Override
    public Customer findById(Long id) {
        TypedQuery<Customer> query = entityManager.createQuery("select c from Customer c where c.id = :id", Customer.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void save(Customer model) {
        if(model.getId() != null){
            entityManager.merge(model);
        }else {
            entityManager.persist(model);
        }

    }

    @Override
    public void remove(Long id) {
        Customer customer = findById(id);
        if(customer != null){
            entityManager.remove(id);
        }

    }
}
