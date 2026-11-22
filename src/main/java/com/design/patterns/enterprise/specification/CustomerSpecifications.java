package com.design.patterns.enterprise.specification;

import com.design.patterns.enterprise.repository.Customer;
import java.util.Objects;

public final class CustomerSpecifications {
    private CustomerSpecifications() {
    }

    public static Specification<Customer> active() {
        return Customer::active;
    }

    public static Specification<Customer> inRegion(String region) {
        Objects.requireNonNull(region, "region");
        if (region.isBlank()) {
            throw new IllegalArgumentException("region must not be blank");
        }
        return customer -> region.equals(customer.region());
    }
}
