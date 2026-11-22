package com.design.patterns.behavioral.interpreter;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;
import org.junit.jupiter.api.Test;

class InterpreterTest {
    @Test
    void evaluatesNestedRulesAgainstFacts() {
        var rule = new InterpreterExample.And(
                new InterpreterExample.Variable("employee"),
                new InterpreterExample.Not(new InterpreterExample.Variable("suspended")));
        assertTrue(rule.evaluate(Set.of("employee")));
        assertFalse(rule.evaluate(Set.of("employee", "suspended")));
        assertFalse(rule.evaluate(Set.of()));
        var or = new InterpreterExample.Or(new InterpreterExample.Variable("admin"), rule);
        assertTrue(or.evaluate(Set.of("admin")));
    }

    @Test
    void rejectsBadExpressions() {
        assertThrows(IllegalArgumentException.class, () -> new InterpreterExample.Variable(""));
        assertThrows(NullPointerException.class, () -> new InterpreterExample.Not(null));
        assertThrows(NullPointerException.class, () -> new InterpreterExample.And(null,
                new InterpreterExample.Variable("ok")));
        assertThrows(NullPointerException.class, () -> new InterpreterExample.Variable("ok").evaluate(null));
    }
}
