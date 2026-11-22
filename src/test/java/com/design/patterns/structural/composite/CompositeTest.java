package com.design.patterns.structural.composite;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CompositeTest {
    @Test
    void calculatesNestedTreeSizes() {
        FileNode root = new Directory().add(new Document("a", 10))
                .add(new Directory().add(new Document("b", 25)));
        assertEquals(35, root.size());
        assertEquals(0, new Directory().size());
    }

    @Test
    void rejectsInvalidOrOverflowingElements() {
        assertThrows(IllegalArgumentException.class, () -> new Document("", 1));
        assertThrows(IllegalArgumentException.class, () -> new Document("a", -1));
        assertThrows(NullPointerException.class, () -> new Directory().add(null));
        FileNode root = new Directory().add(new Document("a", Long.MAX_VALUE))
                .add(new Document("b", 1));
        assertThrows(ArithmeticException.class, root::size);
    }
}
