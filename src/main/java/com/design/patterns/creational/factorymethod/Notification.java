package com.design.patterns.creational.factorymethod;

/** The product created by a notification factory method. */
public interface Notification {
    String send(String recipient, String message);
}
