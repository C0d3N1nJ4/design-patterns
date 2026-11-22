package com.design.patterns.behavioral.chainofresponsibility;

import java.math.BigDecimal;

public final class VicePresident extends ApprovalHandler {
    public VicePresident() {
        super("Vice President", new BigDecimal("1500.00"));
    }
}
