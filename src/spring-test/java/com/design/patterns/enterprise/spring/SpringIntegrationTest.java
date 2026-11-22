package com.design.patterns.enterprise.spring;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import com.design.patterns.enterprise.repository.Customer;
import com.design.patterns.enterprise.repository.CustomerDirectory;
import com.design.patterns.enterprise.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class SpringIntegrationTest {
    @Test
    void constructorInjectionWiresRepositoryPortAndApplicationService() {
        try (var context = new AnnotationConfigApplicationContext(EnterpriseSpringConfiguration.class)) {
            var service = context.getBean(CustomerDirectory.class);
            var repository = context.getBean(CustomerRepository.class);
            service.register(new Customer("C-1", "Alex", "NL", true));
            assertEquals("Alex", repository.findById("C-1").orElseThrow().name());
            assertSame(repository, context.getBean(CustomerRepository.class));
        }
    }
}
