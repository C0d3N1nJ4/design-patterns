package com.design.patterns.enterprise.cqrs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class CqrsTest {
    @Test
    void writesAndReadsHaveDistinctConsistencyBoundaries() {
        var events = new InMemoryEventStore();
        var readModel = new BalanceReadModel();
        var writes = new DepositCommandService(events);
        var reads = new BalanceQueryService(readModel);
        var projector = new DepositProjector(events, readModel);
        var command = new DepositCommand("cmd-1", "account-1", new BigDecimal("25.00"));
        assertTrue(writes.deposit(command));
        assertEquals(BigDecimal.ZERO, reads.balance("account-1"));
        projector.replayAll();
        assertEquals(new BigDecimal("25.00"), reads.balance("account-1"));
        assertFalse(writes.deposit(command));
        projector.replayAll();
        assertEquals(new BigDecimal("25.00"), reads.balance("account-1"));
    }

    @Test
    void replaysMultipleDepositsAndRejectsIdempotencyConflict() {
        var events = new InMemoryEventStore();
        var writes = new DepositCommandService(events);
        var readModel = new BalanceReadModel();
        writes.deposit(new DepositCommand("cmd-1", "A", new BigDecimal("5.00")));
        writes.deposit(new DepositCommand("cmd-2", "A", new BigDecimal("7.00")));
        assertThrows(IllegalArgumentException.class,
                () -> writes.deposit(new DepositCommand("cmd-1", "B", BigDecimal.ONE)));
        new DepositProjector(events, readModel).replayAll();
        assertEquals(new BigDecimal("12.00"), readModel.balance("A"));
        assertEquals(BigDecimal.ZERO, readModel.balance("B"));
        assertEquals(2, events.all().size());
    }

    @Test
    void rejectsInvalidCommandsAndExposesReadOnlyEvents() {
        assertThrows(IllegalArgumentException.class,
                () -> new DepositCommand("id", "A", BigDecimal.ZERO));
        assertThrows(IllegalArgumentException.class,
                () -> new DepositCommand(" ", "A", BigDecimal.ONE));
        assertThrows(NullPointerException.class,
                () -> new DepositCommand("id", "A", null));
        assertThrows(UnsupportedOperationException.class, () ->
                new InMemoryEventStore().all().clear());
    }
}
