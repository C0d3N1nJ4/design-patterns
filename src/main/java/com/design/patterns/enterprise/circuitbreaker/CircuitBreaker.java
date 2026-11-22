package com.design.patterns.enterprise.circuitbreaker;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.util.Objects;
import java.util.concurrent.Callable;

/** Minimal thread-safe state machine with an injected clock for deterministic tests. */
public final class CircuitBreaker {
    public enum State {
        CLOSED, OPEN, HALF_OPEN
    }

    private final int failureThreshold;
    private final Duration resetTimeout;
    private final Clock clock;
    private State state = State.CLOSED;
    private int failures;
    private Instant openedAt;

    public CircuitBreaker(int failureThreshold, Duration resetTimeout, Clock clock) {
        if (failureThreshold < 1) {
            throw new IllegalArgumentException("failureThreshold must be positive");
        }
        this.resetTimeout = Objects.requireNonNull(resetTimeout, "resetTimeout");
        if (resetTimeout.isNegative() || resetTimeout.isZero()) {
            throw new IllegalArgumentException("resetTimeout must be positive");
        }
        this.failureThreshold = failureThreshold;
        this.clock = Objects.requireNonNull(clock, "clock");
    }

    public synchronized State state() {
        return state;
    }

    public synchronized <T> T execute(Callable<T> action) throws Exception {
        Objects.requireNonNull(action, "action");
        if (state == State.OPEN) {
            if (Instant.now(clock).isBefore(openedAt.plus(resetTimeout))) {
                throw new CircuitOpenException();
            }
            state = State.HALF_OPEN;
        }
        try {
            var result = action.call();
            failures = 0;
            state = State.CLOSED;
            return result;
        } catch (Exception failure) {
            failures++;
            if (state == State.HALF_OPEN || failures >= failureThreshold) {
                openedAt = Instant.now(clock);
                state = State.OPEN;
            }
            throw failure;
        }
    }
}
