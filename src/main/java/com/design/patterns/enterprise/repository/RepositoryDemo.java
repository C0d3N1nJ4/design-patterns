package com.design.patterns.enterprise.repository;

public final class RepositoryDemo {
    private RepositoryDemo() {
    }

    public static void main(String[] args) {
        var directory = new CustomerDirectory(new InMemoryCustomerRepository());
        directory.register(new Customer("C-1", "Alex", "NL", true));
        System.out.println("Found customer: " + directory.lookup("C-1").orElseThrow().name());
    }
}
