package com.design.patterns.behavioral.interpreter;

import java.util.Set;

public final class InterpreterDemo {
    private InterpreterDemo() {
    }

    public static void main(String[] args) {
        InterpreterExample.Expression rule = new InterpreterExample.And(
                new InterpreterExample.Variable("employee"),
                new InterpreterExample.Not(new InterpreterExample.Variable("suspended")));
        System.out.println("Access allowed: " + rule.evaluate(Set.of("employee")));
    }
}
