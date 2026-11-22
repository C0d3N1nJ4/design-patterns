package com.design.patterns.enterprise.circuitbreaker;

public final class CircuitOpenException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public CircuitOpenException() {
        super("Circuit open: request rejected");
    }
}
