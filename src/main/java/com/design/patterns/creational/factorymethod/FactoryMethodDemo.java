package com.design.patterns.creational.factorymethod;

/** Demonstrates extending a workflow without modifying its creator. */
public final class FactoryMethodDemo {
    private FactoryMethodDemo() {
    }

    public static void main(String[] args) {
        NotificationService email = new EmailNotificationService();
        NotificationService sms = new SmsNotificationService();
        System.out.println(email.notifyRecipient("alice@example.test", "Invoice ready"));
        System.out.println(sms.notifyRecipient("+31000000000", "Code sent"));
    }
}
