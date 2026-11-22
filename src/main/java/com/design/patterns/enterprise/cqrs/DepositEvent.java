package com.design.patterns.enterprise.cqrs;

import java.math.BigDecimal;

/** Immutable event describing a successful state-changing command. */
public record DepositEvent(String commandId, String accountId, BigDecimal amount) {
}
