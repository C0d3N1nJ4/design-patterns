package com.design.patterns.behavioral.mediator;

public final class MediatorDemo {
    private MediatorDemo() {
    }

    public static void main(String[] args) {
        var room = new MediatorExample.ChatRoom();
        var alice = new MediatorExample.Member("Alice");
        var bob = new MediatorExample.Member("Bob");
        room.join(alice);
        room.join(bob);
        alice.say("Build ready");
        System.out.println("Bob received: " + bob.inbox().getFirst());
    }
}
