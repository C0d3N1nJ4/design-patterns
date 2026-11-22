package com.design.patterns.structural.decorator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class DecoratorTest {
    @Test
    void composesDecoratorsInDifferentOrders() {
        Report base = new PlainReport("Summary");
        assertEquals("Summary", base.render());
        assertEquals("[2026-01-01] Summary | signed",
                new SignedReport(new TimestampedReport(base)).render());
        assertEquals("[2026-01-01] Summary | signed",
                new TimestampedReport(new SignedReport(base)).render());
    }

    @Test
    void rejectsNullDelegates() {
        assertThrows(NullPointerException.class, () -> new SignedReport(null));
        assertThrows(NullPointerException.class, () -> new TimestampedReport(null));
        assertThrows(NullPointerException.class, () -> new PlainReport(null));
    }
}
