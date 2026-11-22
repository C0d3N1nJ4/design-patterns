package com.design.patterns.enterprise.retry;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.Test;

class RetryTest {
    @Test
    void retriesTransientFailuresWithExponentialBackoff() throws Exception {
        var durations = new ArrayList<Duration>();
        var attempts = new AtomicInteger();
        var policy = new RetryPolicy(4, Duration.ofMillis(100),
                e -> e instanceof TransientServiceException, durations::add);
        var result = policy.execute(() -> {
            if (attempts.incrementAndGet() <= 2) {
                throw new TransientServiceException("try again");
            }
            return "done";
        });
        assertEquals("done", result);
        assertEquals(3, attempts.get());
        assertEquals(List.of(Duration.ofMillis(100), Duration.ofMillis(200)), durations);
    }

    @Test
    void neverRetriesPermanentErrorsAndStopsAtLimit() {
        var attempts = new AtomicInteger();
        var policy = new RetryPolicy(3, Duration.ZERO,
                e -> e instanceof TransientServiceException, duration -> { });
        assertThrows(IllegalArgumentException.class, () -> policy.execute(() -> {
            attempts.incrementAndGet();
            throw new IllegalArgumentException("permanent");
        }));
        assertEquals(1, attempts.get());
        assertThrows(TransientServiceException.class, () -> policy.execute(() -> {
            attempts.incrementAndGet();
            throw new TransientServiceException("temporary");
        }));
        assertEquals(4, attempts.get());
    }

    @Test
    void interruptionPropagatesWithoutAnotherAttempt() {
        var attempts = new AtomicInteger();
        var policy = new RetryPolicy(3, Duration.ofMillis(10), e -> true,
                duration -> { throw new InterruptedException("cancelled"); });
        assertThrows(InterruptedException.class, () -> policy.execute(() -> {
            attempts.incrementAndGet();
            throw new TransientServiceException("temporary");
        }));
        assertEquals(1, attempts.get());
    }

    @Test
    void validatesPolicyInputs() {
        assertThrows(IllegalArgumentException.class, () -> new RetryPolicy(0, Duration.ZERO, e -> true, d -> { }));
        assertThrows(IllegalArgumentException.class, () ->
                new RetryPolicy(2, Duration.ofMillis(-1), e -> true, d -> { }));
        assertThrows(NullPointerException.class, () -> new RetryPolicy(2, Duration.ZERO, null, d -> { }));
    }
}
