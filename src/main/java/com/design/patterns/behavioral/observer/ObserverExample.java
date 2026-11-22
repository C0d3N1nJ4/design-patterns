package com.design.patterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

/** Publisher notifies subscribers synchronously in registration order. */
public final class ObserverExample {
    private ObserverExample() {
    }

    public static final class OrderEvents {
        private final List<Consumer<String>> listeners = new ArrayList<>();

        public void subscribe(Consumer<String> listener) {
            listeners.add(Objects.requireNonNull(listener, "listener"));
        }

        public void publish(String orderId) {
            if (orderId == null || orderId.isBlank()) {
                throw new IllegalArgumentException("orderId must not be blank");
            }
            for (var listener : List.copyOf(listeners)) {
                listener.accept(orderId);
            }
        }

        public int subscriberCount() {
            return listeners.size();
        }
    }
}
