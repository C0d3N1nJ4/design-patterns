package com.design.patterns.behavioral.observer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class ObserverTest {
    @Test
    void notifiesListenersInSubscriptionOrder() {
        var events = new ObserverExample.OrderEvents();
        var received = new ArrayList<String>();
        events.subscribe(id -> received.add("email:" + id));
        events.subscribe(id -> received.add("audit:" + id));
        events.publish("42");
        assertEquals(List.of("email:42", "audit:42"), received);
        assertEquals(2, events.subscriberCount());
    }

    @Test
    void rejectsInvalidSubscriptionsAndEvents() {
        var events = new ObserverExample.OrderEvents();
        assertThrows(NullPointerException.class, () -> events.subscribe(null));
        assertThrows(IllegalArgumentException.class, () -> events.publish(""));
        assertThrows(IllegalArgumentException.class, () -> events.publish(null));
    }
}
