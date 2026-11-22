package com.design.patterns.enterprise.cqrs;

import java.math.BigDecimal;
import java.util.Objects;

/** Read-side service depends only on the projection. */
public final class BalanceQueryService {
    private final BalanceReadModel readModel;

    public BalanceQueryService(BalanceReadModel readModel) {
        this.readModel = Objects.requireNonNull(readModel, "readModel");
    }

    public BigDecimal balance(String accountId) {
        return readModel.balance(accountId);
    }
}
