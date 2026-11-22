package com.design.patterns.enterprise.cqrs;

import java.math.BigDecimal;

public final class CqrsDemo {
    private CqrsDemo() {
    }

    public static void main(String[] args) {
        var events = new InMemoryEventStore();
        var projection = new BalanceReadModel();
        var writes = new DepositCommandService(events);
        var reads = new BalanceQueryService(projection);
        writes.deposit(new DepositCommand("cmd-1", "account-1", new BigDecimal("25.00")));
        System.out.println("Before projection: " + reads.balance("account-1"));
        new DepositProjector(events, projection).replayAll();
        System.out.println("After projection: " + reads.balance("account-1"));
    }
}
