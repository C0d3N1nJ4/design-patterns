package com.design.patterns.creational.singleton;

import java.util.Map;

/**
 * JVM-wide, immutable settings snapshot.
 * Enum construction is thread-safe and protects against duplicate instances
 * through normal serialization and reflection mechanisms.
 */
public enum ApplicationSettings {
    INSTANCE;

    private final Map<String, String> defaults = Map.of(
            "currency", "EUR",
            "region", "eu-west"
    );

    public String defaultValue(String key) {
        if (key == null || key.isBlank()) {
            throw new IllegalArgumentException("key must not be blank");
        }
        var value = defaults.get(key);
        if (value == null) {
            throw new IllegalArgumentException("Unknown setting: " + key);
        }
        return value;
    }
}
