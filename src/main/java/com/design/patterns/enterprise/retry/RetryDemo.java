package com.design.patterns.enterprise.retry;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

public final class RetryDemo {
    private RetryDemo() {
    }

    public static void main(String[] args) throws Exception {
        var attempts = new AtomicInteger();
        var policy = new RetryPolicy(3, Duration.ofMillis(100),
                failure -> failure instanceof TransientServiceException,
                duration -> { }); // no waiting in the learning demo
        var result = policy.execute(() -> {
            if (attempts.incrementAndGet() < 3) {
                throw new TransientServiceException("Temporary outage");
            }
            return "Payment confirmed";
        });
        System.out.println(result + " after " + attempts.get() + " attempts");
    }
}
