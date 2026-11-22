package com.design.patterns.enterprise.repository;

import java.util.List;
import java.util.Optional;

/** Port that hides how customers are stored. */
public interface CustomerRepository {
    void save(Customer customer);

    Optional<Customer> findById(String id);

    List<Customer> findAll();
}
