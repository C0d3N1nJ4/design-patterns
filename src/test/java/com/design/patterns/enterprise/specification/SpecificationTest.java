package com.design.patterns.enterprise.specification;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.design.patterns.enterprise.repository.Customer;
import org.junit.jupiter.api.Test;

class SpecificationTest {
    @Test
    void composesAndOrNotWithoutPersistence() {
        var activeNl = CustomerSpecifications.active().and(CustomerSpecifications.inRegion("NL"));
        var alex = new Customer("C-1", "Alex", "NL", true);
        var sam = new Customer("C-2", "Sam", "DE", true);
        var inactive = new Customer("C-3", "Jo", "NL", false);
        assertTrue(activeNl.isSatisfiedBy(alex));
        assertFalse(activeNl.isSatisfiedBy(sam));
        assertFalse(activeNl.isSatisfiedBy(inactive));
        assertTrue(activeNl.or(CustomerSpecifications.inRegion("DE")).isSatisfiedBy(sam));
        assertTrue(activeNl.not().isSatisfiedBy(sam));
    }

    @Test
    void rejectsInvalidCompositions() {
        assertThrows(NullPointerException.class, () -> CustomerSpecifications.active().and(null));
        assertThrows(NullPointerException.class, () -> CustomerSpecifications.active().or(null));
        assertThrows(IllegalArgumentException.class, () -> CustomerSpecifications.inRegion(" "));
        assertThrows(NullPointerException.class, () -> Specification.from(null));
    }
}
