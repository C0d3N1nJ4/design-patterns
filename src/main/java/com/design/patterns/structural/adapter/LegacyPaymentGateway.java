package com.design.patterns.structural.adapter;

import java.math.BigDecimal;
import java.util.Objects;

/** Existing third-party API accepts cents, while our application uses decimal money. */
public final class LegacyPaymentGateway {
    public String chargeCents(long cents) {
        if (cents < 0) {
            throw new IllegalArgumentException("cents must be nonnegative");
        }
        return "LEGACY charged " + cents + " cents";
    }
}

interface PaymentProcessor {
    String charge(BigDecimal amount);
}

final class LegacyPaymentAdapter implements PaymentProcessor {
    private final LegacyPaymentGateway gateway;

    LegacyPaymentAdapter(LegacyPaymentGateway gateway) {
        this.gateway = Objects.requireNonNull(gateway, "gateway");
    }

    @Override
    public String charge(BigDecimal amount) {
        Objects.requireNonNull(amount, "amount");
        if (amount.signum() < 0) {
            throw new IllegalArgumentException("amount must be nonnegative");
        }
        return gateway.chargeCents(amount.movePointRight(2).longValueExact());
    }
}
