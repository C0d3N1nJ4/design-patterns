package com.design.patterns.behavioral.chainofresponsibility;

/** Immutable result allows deterministic assertions and audit-style output. */
public record ApprovalDecision(String reference, String approvedBy) {
}
