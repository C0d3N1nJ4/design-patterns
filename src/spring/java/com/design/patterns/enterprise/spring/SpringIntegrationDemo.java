package com.design.patterns.enterprise.spring;

import com.design.patterns.enterprise.repository.Customer;
import com.design.patterns.enterprise.repository.CustomerDirectory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public final class SpringIntegrationDemo {
    private SpringIntegrationDemo() {
    }

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(EnterpriseSpringConfiguration.class)) {
            var directory = context.getBean(CustomerDirectory.class);
            directory.register(new Customer("C-1", "Alex", "NL", true));
            System.out.println("Spring wired customer: " + directory.lookup("C-1").orElseThrow().name());
        }
    }
}
