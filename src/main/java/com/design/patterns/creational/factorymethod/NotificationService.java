package com.design.patterns.creational.factorymethod;

import java.util.Objects;

/**
 * Creator: the workflow delegates product creation to subclasses.
 */
public abstract class NotificationService {
    protected abstract Notification createNotification();

    public final String notifyRecipient(String recipient, String message) {
        if (recipient == null || recipient.isBlank()) {
            throw new IllegalArgumentException("recipient must not be blank");
        }
        Objects.requireNonNull(message, "message");
        if (message.isBlank()) {
            throw new IllegalArgumentException("message must not be blank");
        }
        return Objects.requireNonNull(createNotification(), "notification").send(recipient, message);
    }
}
