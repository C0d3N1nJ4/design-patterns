package com.design.patterns.behavioral.state;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class StateTest {
    @Test
    void followsDocumentLifecycle() {
        var doc = new StateExample.Document();
        assertEquals("Draft", doc.status());
        doc.submit();
        assertEquals("Pending", doc.status());
        doc.approve();
        assertEquals("Approved", doc.status());
    }

    @Test
    void refusesInvalidTransitions() {
        var doc = new StateExample.Document();
        assertThrows(IllegalStateException.class, doc::approve);
        doc.submit();
        assertThrows(IllegalStateException.class, doc::submit);
        doc.approve();
        assertThrows(IllegalStateException.class, doc::approve);
        assertThrows(IllegalStateException.class, doc::submit);
    }
}
