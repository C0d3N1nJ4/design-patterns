package com.design.patterns.behavioral.iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class IteratorTest {
    @Test
    void traversesItemsAndSnapshotsExistingIterators() {
        var backlog = new IteratorExample.Backlog().add("A").add("B");
        var iter = backlog.iterator();
        backlog.add("C");
        var snapshot = new ArrayList<String>();
        iter.forEachRemaining(snapshot::add);
        assertEquals(List.of("A", "B"), snapshot);
        assertEquals(3, backlog.size());
    }

    @Test
    void iteratorIsReadOnlyAndValidatesInput() {
        var backlog = new IteratorExample.Backlog().add("A");
        assertThrows(UnsupportedOperationException.class, () -> backlog.iterator().remove());
        assertThrows(IllegalArgumentException.class, () -> backlog.add(" "));
    }
}
