package com.design.patterns.creational.singleton;

/** Demonstrates a single immutable settings object shared by callers. */
public final class SingletonDemo {
    private SingletonDemo() {
    }

    public static void main(String[] args) {
        var first = ApplicationSettings.INSTANCE;
        var second = ApplicationSettings.INSTANCE;
        System.out.println("Same instance: " + (first == second));
        System.out.println("Default currency: " + first.defaultValue("currency"));
    }
}
