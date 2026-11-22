package com.design.patterns.behavioral.mediator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;

class MediatorTest {
    @Test
    void forwardsMessagesOnlyToPeers() {
        var room = new MediatorExample.ChatRoom();
        var a = new MediatorExample.Member("Alice");
        var b = new MediatorExample.Member("Bob");
        room.join(a);
        room.join(b);
        a.say("Hello");
        assertEquals(List.of("Alice: Hello"), b.inbox());
        assertEquals(List.of(), a.inbox());
    }

    @Test
    void rejectsMissingMembershipAndDuplicateJoins() {
        var room = new MediatorExample.ChatRoom();
        var user = new MediatorExample.Member("User");
        assertThrows(IllegalStateException.class, () -> user.say("Hello"));
        room.join(user);
        assertThrows(IllegalStateException.class, () -> room.join(user));
        assertThrows(IllegalArgumentException.class, () -> user.say(""));
        assertThrows(IllegalArgumentException.class, () -> new MediatorExample.Member(""));
    }
}
