package com.design.patterns.enterprise.repository;

import java.util.Objects;
import java.util.Optional;

/** Application service depends on an interface, not a database or framework. */
public final class CustomerDirectory {
    private final CustomerRepository customers;

    public CustomerDirectory(CustomerRepository customers) {
        this.customers = Objects.requireNonNull(customers, "customers");
    }

    public void register(Customer customer) {
        customers.save(customer);
    }

    public Optional<Customer> lookup(String id) {
        return customers.findById(id);
    }
}
