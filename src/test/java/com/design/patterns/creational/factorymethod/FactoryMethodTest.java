package com.design.patterns.creational.factorymethod;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class FactoryMethodTest {
    @Test
    void creatorsChooseDifferentProducts() {
        assertEquals("EMAIL to alice@example.test: Hello",
                new EmailNotificationService().notifyRecipient("alice@example.test", "Hello"));
        assertEquals("SMS to 123: Hello",
                new SmsNotificationService().notifyRecipient("123", "Hello"));
    }

    @Test
    void creatorCanBeExtendedWithoutChangingWorkflow() {
        NotificationService custom = new NotificationService() {
            @Override
            protected Notification createNotification() {
                return (recipient, message) -> "PUSH to " + recipient + ": " + message;
            }
        };
        assertTrue(custom.notifyRecipient("device", "Hi").startsWith("PUSH"));
    }

    @Test
    void validatesInputsAndRejectsNullFactoryProduct() {
        NotificationService service = new EmailNotificationService();
        assertThrows(IllegalArgumentException.class, () -> service.notifyRecipient("", "hello"));
        assertThrows(IllegalArgumentException.class, () -> service.notifyRecipient("alice", " "));
        assertThrows(NullPointerException.class, () -> service.notifyRecipient("alice", null));

        NotificationService invalid = new NotificationService() {
            @Override
            protected Notification createNotification() {
                return null;
            }
        };
        assertThrows(NullPointerException.class, () -> invalid.notifyRecipient("alice", "hello"));
    }
}
