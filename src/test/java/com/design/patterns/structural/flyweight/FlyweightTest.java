package com.design.patterns.structural.flyweight;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class FlyweightTest {
    @Test
    void reusesIdenticalStylesButNotDifferentStyles() {
        var factory = new TextStyleFactory();
        var a = factory.style("Mono", 12);
        assertSame(a, factory.style("Mono", 12));
        assertNotSame(a, factory.style("Mono", 14));
        assertEquals(2, factory.cachedStyles());
        assertEquals("A@3 [Mono/12]", a.render('A', 3));
    }

    @Test
    void rejectsInvalidStyles() {
        var factory = new TextStyleFactory();
        assertThrows(IllegalArgumentException.class, () -> factory.style("", 12));
        assertThrows(IllegalArgumentException.class, () -> factory.style("Mono", 0));
        assertThrows(IllegalArgumentException.class, () -> factory.style(null, 12));
    }
}
