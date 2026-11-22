package com.design.patterns.enterprise.cqrs;

import java.math.BigDecimal;
import java.util.Objects;

/** Idempotency key is the command ID; only positive amounts are accepted. */
public record DepositCommand(String commandId, String accountId, BigDecimal amount) {
    public DepositCommand {
        requireText(commandId, "commandId");
        requireText(accountId, "accountId");
        Objects.requireNonNull(amount, "amount");
        if (amount.signum() <= 0) {
            throw new IllegalArgumentException("amount must be positive");
        }
    }

    private static void requireText(String value, String name) {
        Objects.requireNonNull(value, name);
        if (value.isBlank()) {
            throw new IllegalArgumentException(name + " must not be blank");
        }
    }
}
