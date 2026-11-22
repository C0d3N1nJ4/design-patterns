package com.design.patterns.enterprise.cqrs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/** In-memory write model with atomic idempotency-key validation. */
public final class InMemoryEventStore {
    private final Map<String, DepositEvent> byCommandId = new HashMap<>();
    private final List<DepositEvent> events = new ArrayList<>();

    public synchronized boolean append(DepositCommand command) {
        Objects.requireNonNull(command, "command");
        var previous = byCommandId.get(command.commandId());
        if (previous != null) {
            if (!previous.accountId().equals(command.accountId())
                    || previous.amount().compareTo(command.amount()) != 0) {
                throw new IllegalArgumentException("Idempotency key used with a different deposit");
            }
            return false;
        }
        var event = new DepositEvent(command.commandId(), command.accountId(), command.amount());
        byCommandId.put(command.commandId(), event);
        events.add(event);
        return true;
    }

    public synchronized List<DepositEvent> all() {
        return List.copyOf(events);
    }
}
