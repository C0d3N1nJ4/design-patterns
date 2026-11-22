package com.design.patterns.enterprise.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class RepositoryTest {
    @Test
    void savesAndLooksUpCustomersThroughAnInterface() {
        CustomerRepository repository = new InMemoryCustomerRepository();
        var directory = new CustomerDirectory(repository);
        var first = new Customer("C-1", "Alex", "NL", true);
        directory.register(first);
        assertEquals(first, directory.lookup("C-1").orElseThrow());
        assertFalse(directory.lookup("missing").isPresent());
        directory.register(new Customer("C-1", "Alex Updated", "NL", false));
        assertEquals("Alex Updated", directory.lookup("C-1").orElseThrow().name());
        assertEquals(1, repository.findAll().size());
    }

    @Test
    void protectsInvariantsAndReadOnlySnapshots() {
        assertThrows(IllegalArgumentException.class, () -> new Customer("", "Alex", "NL", true));
        assertThrows(NullPointerException.class, () -> new Customer(null, "Alex", "NL", true));
        var repository = new InMemoryCustomerRepository();
        assertThrows(NullPointerException.class, () -> repository.save(null));
        assertThrows(NullPointerException.class, () -> repository.findById(null));
        assertThrows(UnsupportedOperationException.class, () ->
                repository.findAll().add(new Customer("A", "B", "NL", true)));
        assertTrue(repository.findAll().isEmpty());
    }
}
