package com.design.patterns.structural.bridge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class BridgeTest {
    @Test
    void urgencyAndTransportVaryIndependently() {
        assertEquals("SMS: [URGENT] Alert", new UrgentNotification(new SmsTransport()).send("Alert"));
        assertEquals("EMAIL: [URGENT] Alert", new UrgentNotification(new EmailTransport()).send("Alert"));
        assertEquals("SMS: Alert", new StandardNotification(new SmsTransport()).send("Alert"));
    }

    @Test
    void validatesNullTransportAndMessage() {
        assertThrows(NullPointerException.class, () -> new StandardNotification(null));
        assertThrows(NullPointerException.class, () -> new StandardNotification(new EmailTransport()).send(null));
    }
}
