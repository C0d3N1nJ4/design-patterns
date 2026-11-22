package com.design.patterns.enterprise.repository;

import java.util.Objects;

/** Customer is immutable; IDs are stable across copies. */
public record Customer(String id, String name, String region, boolean active) {
    public Customer {
        requireText(id, "id");
        requireText(name, "name");
        requireText(region, "region");
    }

    private static void requireText(String value, String field) {
        Objects.requireNonNull(value, field);
        if (value.isBlank()) {
            throw new IllegalArgumentException(field + " must not be blank");
        }
    }
}
