package com.design.patterns.enterprise.cqrs;

import java.util.Objects;

/** Write-side service: validates and appends; it never queries the read model. */
public final class DepositCommandService {
    private final InMemoryEventStore events;

    public DepositCommandService(InMemoryEventStore events) {
        this.events = Objects.requireNonNull(events, "events");
    }

    public boolean deposit(DepositCommand command) {
        return events.append(command);
    }
}
