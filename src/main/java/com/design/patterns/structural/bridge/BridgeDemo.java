package com.design.patterns.structural.bridge;

public final class BridgeDemo {
    private BridgeDemo() {
    }

    public static void main(String[] args) {
        Notification alert = new UrgentNotification(new SmsTransport());
        Notification update = new StandardNotification(new EmailTransport());
        System.out.println(alert.send("Server offline"));
        System.out.println(update.send("Daily report ready"));
    }
}
