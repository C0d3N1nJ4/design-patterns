package com.design.patterns.enterprise.retry;

import java.time.Duration;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.function.Predicate;

/**
 * Retry transient failures with exponential backoff.
 * No wait occurs until the injected Sleeper is called.
 */
public final class RetryPolicy {
    @FunctionalInterface
    public interface Sleeper {
        void sleep(Duration duration) throws InterruptedException;
    }

    private final int maxAttempts;
    private final Duration initialBackoff;
    private final Predicate<Exception> retryable;
    private final Sleeper sleeper;

    public RetryPolicy(int maxAttempts, Duration initialBackoff,
            Predicate<Exception> retryable, Sleeper sleeper) {
        if (maxAttempts < 1) {
            throw new IllegalArgumentException("maxAttempts must be positive");
        }
        this.initialBackoff = Objects.requireNonNull(initialBackoff, "initialBackoff");
        if (initialBackoff.isNegative()) {
            throw new IllegalArgumentException("initialBackoff must not be negative");
        }
        this.maxAttempts = maxAttempts;
        this.retryable = Objects.requireNonNull(retryable, "retryable");
        this.sleeper = Objects.requireNonNull(sleeper, "sleeper");
    }

    public <T> T execute(Callable<T> action) throws Exception {
        Objects.requireNonNull(action, "action");
        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            try {
                return action.call();
            } catch (Exception exception) {
                if (attempt == maxAttempts || !retryable.test(exception)) {
                    throw exception;
                }
                long multiplier = 1L << Math.min(attempt - 1, 60);
                var backoff = initialBackoff.multipliedBy(multiplier);
                sleeper.sleep(backoff);
            }
        }
        throw new IllegalStateException("No attempts executed");
    }
}
