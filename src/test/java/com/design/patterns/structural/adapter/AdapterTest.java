package com.design.patterns.structural.adapter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class AdapterTest {
    @Test
    void convertsDecimalAmountsToLegacyCents() {
        PaymentProcessor processor = new LegacyPaymentAdapter(new LegacyPaymentGateway());
        assertEquals("LEGACY charged 1250 cents", processor.charge(new BigDecimal("12.50")));
        assertEquals("LEGACY charged 0 cents", processor.charge(BigDecimal.ZERO));
    }

    @Test
    void rejectsNegativeFractionalAndOverflowAmounts() {
        PaymentProcessor processor = new LegacyPaymentAdapter(new LegacyPaymentGateway());
        assertThrows(IllegalArgumentException.class, () -> processor.charge(new BigDecimal("-1")));
        assertThrows(ArithmeticException.class, () -> processor.charge(new BigDecimal("1.234")));
        assertThrows(ArithmeticException.class, () -> processor.charge(new BigDecimal("999999999999999999")));
        assertThrows(NullPointerException.class, () -> processor.charge(null));
        assertThrows(NullPointerException.class, () -> new LegacyPaymentAdapter(null));
    }
}
