package com.design.patterns.structural.bridge;

import java.util.Objects;

/** Transport varies independently from notification urgency. */
public abstract class Notification {
    protected final MessageTransport transport;

    protected Notification(MessageTransport transport) {
        this.transport = Objects.requireNonNull(transport, "transport");
    }

    public abstract String send(String message);
}

interface MessageTransport {
    String deliver(String message);
}

final class EmailTransport implements MessageTransport {
    @Override
    public String deliver(String message) {
        return "EMAIL: " + message;
    }
}

final class SmsTransport implements MessageTransport {
    @Override
    public String deliver(String message) {
        return "SMS: " + message;
    }
}

final class UrgentNotification extends Notification {
    UrgentNotification(MessageTransport transport) {
        super(transport);
    }

    @Override
    public String send(String message) {
        return transport.deliver("[URGENT] " + Objects.requireNonNull(message, "message"));
    }
}

final class StandardNotification extends Notification {
    StandardNotification(MessageTransport transport) {
        super(transport);
    }

    @Override
    public String send(String message) {
        return transport.deliver(Objects.requireNonNull(message, "message"));
    }
}
