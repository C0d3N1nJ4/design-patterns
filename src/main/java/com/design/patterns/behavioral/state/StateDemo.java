package com.design.patterns.behavioral.state;

public final class StateDemo {
    private StateDemo() {
    }

    public static void main(String[] args) {
        var document = new StateExample.Document();
        document.submit();
        System.out.println("After submit: " + document.status());
        document.approve();
        System.out.println("After approve: " + document.status());
    }
}
