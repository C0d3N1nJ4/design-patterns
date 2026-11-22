package com.design.patterns.behavioral.chainofresponsibility;

import java.math.BigDecimal;
import java.util.Objects;

/** Forwards requests until a handler's approval limit allows a decision. */
public abstract class ApprovalHandler {
    private final String role;
    private final BigDecimal limit;
    private ApprovalHandler next;

    protected ApprovalHandler(String role, BigDecimal limit) {
        this.role = Objects.requireNonNull(role, "role");
        this.limit = Objects.requireNonNull(limit, "limit");
    }

    public final ApprovalHandler setNext(ApprovalHandler next) {
        if (next == this) {
            throw new IllegalArgumentException("Handler cannot follow itself");
        }
        this.next = Objects.requireNonNull(next, "next");
        return next;
    }

    public final ApprovalDecision approve(ApprovalRequest request) {
        Objects.requireNonNull(request, "request");
        if (request.amount().compareTo(limit) <= 0) {
            return new ApprovalDecision(request.reference(), role);
        }
        if (next == null) {
            throw new IllegalStateException("No approver for amount " + request.amount());
        }
        return next.approve(request);
    }
}
