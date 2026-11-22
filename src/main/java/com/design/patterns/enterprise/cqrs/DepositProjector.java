package com.design.patterns.enterprise.cqrs;

import java.util.Objects;

/** Explicit projection step models lag between writes and eventual reads. */
public final class DepositProjector {
    private final InMemoryEventStore events;
    private final BalanceReadModel readModel;

    public DepositProjector(InMemoryEventStore events, BalanceReadModel readModel) {
        this.events = Objects.requireNonNull(events, "events");
        this.readModel = Objects.requireNonNull(readModel, "readModel");
    }

    public void replayAll() {
        for (var event : events.all()) {
            readModel.apply(event);
        }
    }
}
