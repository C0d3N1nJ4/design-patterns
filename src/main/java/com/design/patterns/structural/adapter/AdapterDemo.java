package com.design.patterns.structural.adapter;

import java.math.BigDecimal;

public final class AdapterDemo {
    private AdapterDemo() {
    }

    public static void main(String[] args) {
        PaymentProcessor processor = new LegacyPaymentAdapter(new LegacyPaymentGateway());
        System.out.println(processor.charge(new BigDecimal("12.50")));
    }
}
