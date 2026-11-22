package com.design.patterns.creational.factorymethod;

public final class SmsNotification implements Notification {
    @Override
    public String send(String recipient, String message) {
        return "SMS to " + recipient + ": " + message;
    }
}
