package com.design.patterns.behavioral.chainofresponsibility;

import java.math.BigDecimal;
import java.util.Objects;

/** Example purchase requiring approval from the first eligible authority. */
public record ApprovalRequest(String reference, BigDecimal amount) {
    public ApprovalRequest {
        Objects.requireNonNull(reference, "reference");
        Objects.requireNonNull(amount, "amount");
        if (reference.isBlank()) {
            throw new IllegalArgumentException("reference must not be blank");
        }
        if (amount.signum() < 0) {
            throw new IllegalArgumentException("amount must not be negative");
        }
    }
}
