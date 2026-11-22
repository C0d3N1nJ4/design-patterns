package com.design.patterns.behavioral.iterator;

public final class IteratorDemo {
    private IteratorDemo() {
    }

    public static void main(String[] args) {
        var backlog = new IteratorExample.Backlog().add("Design").add("Review");
        for (var task : backlog) {
            System.out.println("Task: " + task);
        }
    }
}
