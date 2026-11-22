package com.design.patterns.enterprise.cqrs;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Read-side projection updated separately from the write model.
 * Replaying the same event is safe.
 */
public final class BalanceReadModel {
    private final Map<String, BigDecimal> balances = new HashMap<>();
    private final Set<String> projectedCommands = new HashSet<>();

    public synchronized void apply(DepositEvent event) {
        Objects.requireNonNull(event, "event");
        if (projectedCommands.contains(event.commandId())) {
            return;
        }
        balances.merge(event.accountId(), event.amount(), BigDecimal::add);
        projectedCommands.add(event.commandId());
    }

    public synchronized BigDecimal balance(String accountId) {
        return balances.getOrDefault(Objects.requireNonNull(accountId, "accountId"), BigDecimal.ZERO);
    }
}
