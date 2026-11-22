package com.design.patterns.creational.factorymethod;

public final class EmailNotification implements Notification {
    @Override
    public String send(String recipient, String message) {
        return "EMAIL to " + recipient + ": " + message;
    }
}
