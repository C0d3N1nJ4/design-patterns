package com.design.patterns.behavioral.chainofresponsibility;

import java.math.BigDecimal;

public final class Director extends ApprovalHandler {
    public Director() {
        super("Director", new BigDecimal("500.00"));
    }
}
