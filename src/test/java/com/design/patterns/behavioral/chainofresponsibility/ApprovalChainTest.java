package com.design.patterns.behavioral.chainofresponsibility;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class ApprovalChainTest {
    private static ApprovalRequest request(String amount) {
        return new ApprovalRequest("REQ-1", new BigDecimal(amount));
    }

    private static ApprovalHandler chain() {
        var director = new Director();
        director.setNext(new VicePresident()).setNext(new ChiefExecutive());
        return director;
    }

    @Test
    void firstEligibleApproverHandlesTheRequest() {
        assertEquals("Director", chain().approve(request("500")).approvedBy());
        assertEquals("Vice President", chain().approve(request("500.01")).approvedBy());
        assertEquals("Vice President", chain().approve(request("1500")).approvedBy());
        assertEquals("CEO", chain().approve(request("1500.01")).approvedBy());
    }

    @Test
    void failsExplicitlyWhenNoHandlerCanApprove() {
        assertThrows(IllegalStateException.class, () -> new Director().approve(request("501")));
        assertThrows(IllegalStateException.class, () -> chain().approve(request("100000.01")));
    }

    @Test
    void rejectsInvalidRequestsAndSelfLinking() {
        assertThrows(IllegalArgumentException.class,
                () -> new ApprovalRequest("bad", new BigDecimal("-1")));
        assertThrows(IllegalArgumentException.class,
                () -> new ApprovalRequest(" ", BigDecimal.ZERO));
        assertThrows(NullPointerException.class, () -> new ApprovalRequest("R", null));
        var director = new Director();
        assertThrows(IllegalArgumentException.class, () -> director.setNext(director));
        assertThrows(NullPointerException.class, () -> director.setNext(null));
        assertThrows(NullPointerException.class, () -> director.approve(null));
    }
}
