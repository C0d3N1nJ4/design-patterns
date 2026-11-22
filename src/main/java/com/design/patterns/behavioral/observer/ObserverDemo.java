package com.design.patterns.behavioral.observer;

public final class ObserverDemo {
    private ObserverDemo() {
    }

    public static void main(String[] args) {
        var events = new ObserverExample.OrderEvents();
        events.subscribe(id -> System.out.println("Email notified: " + id));
        events.subscribe(id -> System.out.println("Audit recorded: " + id));
        events.publish("ORDER-42");
    }
}
