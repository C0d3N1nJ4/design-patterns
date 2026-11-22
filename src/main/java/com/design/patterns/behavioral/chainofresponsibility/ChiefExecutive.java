package com.design.patterns.behavioral.chainofresponsibility;

import java.math.BigDecimal;

public final class ChiefExecutive extends ApprovalHandler {
    public ChiefExecutive() {
        super("CEO", new BigDecimal("100000.00"));
    }
}
