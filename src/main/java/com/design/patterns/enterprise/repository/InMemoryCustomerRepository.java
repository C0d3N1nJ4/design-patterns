package com.design.patterns.enterprise.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/** Thread-safe in-memory adapter used for lessons and tests. */
public final class InMemoryCustomerRepository implements CustomerRepository {
    private final Map<String, Customer> customers = new ConcurrentHashMap<>();

    @Override
    public void save(Customer customer) {
        var valid = Objects.requireNonNull(customer, "customer");
        customers.put(valid.id(), valid);
    }

    @Override
    public Optional<Customer> findById(String id) {
        return Optional.ofNullable(customers.get(Objects.requireNonNull(id, "id")));
    }

    @Override
    public List<Customer> findAll() {
        return List.copyOf(new ArrayList<>(customers.values()));
    }
}
