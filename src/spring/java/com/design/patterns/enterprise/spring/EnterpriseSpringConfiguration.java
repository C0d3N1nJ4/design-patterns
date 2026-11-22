package com.design.patterns.enterprise.spring;

import com.design.patterns.enterprise.repository.CustomerDirectory;
import com.design.patterns.enterprise.repository.CustomerRepository;
import com.design.patterns.enterprise.repository.InMemoryCustomerRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/** Opt-in dependency injection of framework-independent application ports. */
@Configuration(proxyBeanMethods = false)
public class EnterpriseSpringConfiguration {
    @Bean
    public CustomerRepository customerRepository() {
        return new InMemoryCustomerRepository();
    }

    @Bean
    public CustomerDirectory customerDirectory(CustomerRepository repository) {
        return new CustomerDirectory(repository);
    }
}
