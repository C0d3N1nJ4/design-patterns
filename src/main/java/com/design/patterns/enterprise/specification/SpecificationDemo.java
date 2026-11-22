package com.design.patterns.enterprise.specification;

import com.design.patterns.enterprise.repository.Customer;
import java.util.List;

public final class SpecificationDemo {
    private SpecificationDemo() {
    }

    public static void main(String[] args) {
        var eligible = CustomerSpecifications.active()
                .and(CustomerSpecifications.inRegion("NL"));
        long count = List.of(
                new Customer("1", "Alex", "NL", true),
                new Customer("2", "Sam", "DE", true),
                new Customer("3", "Jo", "NL", false))
                .stream().filter(eligible::isSatisfiedBy).count();
        System.out.println("Eligible customers: " + count);
    }
}
