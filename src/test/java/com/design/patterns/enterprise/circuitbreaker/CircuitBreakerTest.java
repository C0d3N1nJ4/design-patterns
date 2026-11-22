package com.design.patterns.enterprise.circuitbreaker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import org.junit.jupiter.api.Test;

class CircuitBreakerTest {
    private static final class MutableClock extends Clock {
        private Instant now = Instant.parse("2026-01-01T00:00:00Z");

        void advance(Duration delta) {
            now = now.plus(delta);
        }

        @Override
        public ZoneId getZone() {
            return ZoneId.of("UTC");
        }

        @Override
        public Clock withZone(ZoneId zone) {
            return Clock.fixed(now, zone);
        }

        @Override
        public Instant instant() {
            return now;
        }
    }

    @Test
    void opensAfterThresholdAndRecoversAfterTimeout() throws Exception {
        var clock = new MutableClock();
        var breaker = new CircuitBreaker(2, Duration.ofSeconds(10), clock);
        assertThrows(IllegalStateException.class, () -> breaker.execute(() -> {
            throw new IllegalStateException("temporary");
        }));
        assertEquals(CircuitBreaker.State.CLOSED, breaker.state());
        assertThrows(IllegalStateException.class, () -> breaker.execute(() -> {
            throw new IllegalStateException("temporary");
        }));
        assertEquals(CircuitBreaker.State.OPEN, breaker.state());
        assertThrows(CircuitOpenException.class, () -> breaker.execute(() -> "blocked"));
        clock.advance(Duration.ofSeconds(10));
        assertEquals("recovered", breaker.execute(() -> "recovered"));
        assertEquals(CircuitBreaker.State.CLOSED, breaker.state());
    }

    @Test
    void failedHalfOpenProbeReopensCircuit() {
        var clock = new MutableClock();
        var breaker = new CircuitBreaker(1, Duration.ofSeconds(5), clock);
        assertThrows(IllegalStateException.class, () -> breaker.execute(() -> {
            throw new IllegalStateException("fail");
        }));
        clock.advance(Duration.ofSeconds(5));
        assertThrows(IllegalStateException.class, () -> breaker.execute(() -> {
            throw new IllegalStateException("still failing");
        }));
        assertEquals(CircuitBreaker.State.OPEN, breaker.state());
        assertThrows(CircuitOpenException.class, () -> breaker.execute(() -> "blocked"));
    }

    @Test
    void validatesConfiguration() {
        assertThrows(IllegalArgumentException.class, () ->
                new CircuitBreaker(0, Duration.ofSeconds(1), Clock.systemUTC()));
        assertThrows(IllegalArgumentException.class, () ->
                new CircuitBreaker(1, Duration.ZERO, Clock.systemUTC()));
        assertThrows(NullPointerException.class, () ->
                new CircuitBreaker(1, Duration.ofSeconds(1), null));
    }
}
