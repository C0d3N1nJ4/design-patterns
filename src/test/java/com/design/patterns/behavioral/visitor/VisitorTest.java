package com.design.patterns.behavioral.visitor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.Test;

class VisitorTest {
    @Test
    void calculatesAnnualTotalForDifferentItemTypes() {
        List<VisitorExample.Item> items = List.of(
                new VisitorExample.Book("Book", new BigDecimal("30.00")),
                new VisitorExample.Subscription("Plan", new BigDecimal("10.00")));
        assertEquals(new BigDecimal("150.00"), VisitorExample.totalAnnual(items));
        assertEquals(BigDecimal.ZERO, VisitorExample.totalAnnual(List.of()));
    }

    @Test
    void rejectsInvalidProductsAndLists() {
        assertThrows(IllegalArgumentException.class,
                () -> new VisitorExample.Book("", BigDecimal.ONE));
        assertThrows(IllegalArgumentException.class,
                () -> new VisitorExample.Subscription("Plan", new BigDecimal("-1")));
        assertThrows(NullPointerException.class, () -> VisitorExample.totalAnnual(null));
        assertThrows(NullPointerException.class,
                () -> new VisitorExample.Book("Book", BigDecimal.ONE).accept(null));
    }
}
