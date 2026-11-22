package com.design.patterns.enterprise.circuitbreaker;

import java.time.Clock;
import java.time.Duration;

public final class CircuitBreakerDemo {
    private CircuitBreakerDemo() {
    }

    public static void main(String[] args) throws Exception {
        var breaker = new CircuitBreaker(2, Duration.ofSeconds(30), Clock.systemUTC());
        for (int i = 0; i < 2; i++) {
            try {
                breaker.execute(() -> {
                    throw new IllegalStateException("Upstream unavailable");
                });
            } catch (IllegalStateException ignored) {
                System.out.println("Failure recorded");
            }
        }
        System.out.println("Circuit state: " + breaker.state());
        try {
            breaker.execute(() -> "Not executed");
        } catch (CircuitOpenException ignored) {
            System.out.println("Further call blocked");
        }
    }
}
