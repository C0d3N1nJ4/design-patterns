package com.design.patterns.behavioral.chainofresponsibility;

import java.math.BigDecimal;

/** Run with: java -cp target/classes com.design.patterns.behavioral.chainofresponsibility.ApprovalChainDemo */
public final class ApprovalChainDemo {
    private ApprovalChainDemo() {
    }

    public static void main(String[] args) {
        var director = new Director();
        var vicePresident = new VicePresident();
        director.setNext(vicePresident).setNext(new ChiefExecutive());
        for (var amount : new String[] {"100.00", "900.00", "2000.00"}) {
            var decision = director.approve(new ApprovalRequest("PO-" + amount,
                    new BigDecimal(amount)));
            System.out.println(decision.reference() + " approved by " + decision.approvedBy());
        }
    }
}
