package com.design.patterns.creational.singleton;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;

class SingletonTest {
    @Test
    void callersSeeSameInstance() {
        assertSame(ApplicationSettings.INSTANCE, ApplicationSettings.INSTANCE);
        assertEquals("EUR", ApplicationSettings.INSTANCE.defaultValue("currency"));
    }

    @Test
    void threadsSeeSameInstance() throws Exception {
        try (var executor = Executors.newFixedThreadPool(4)) {
            var first = executor.submit(() -> ApplicationSettings.INSTANCE);
            var second = executor.submit(() -> ApplicationSettings.INSTANCE);
            assertSame(first.get(5, TimeUnit.SECONDS), second.get(5, TimeUnit.SECONDS));
        }
    }

    @Test
    void rejectsUnknownSettings() {
        assertThrows(IllegalArgumentException.class,
                () -> ApplicationSettings.INSTANCE.defaultValue("missing"));
        assertThrows(IllegalArgumentException.class,
                () -> ApplicationSettings.INSTANCE.defaultValue(" "));
    }
}
