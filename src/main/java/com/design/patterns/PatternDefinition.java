package com.design.patterns;

import java.util.Objects;

/** Catalog metadata, not an implementation of a pattern. */
public record PatternDefinition(String name, PatternCategory category) {
    public PatternDefinition {
        Objects.requireNonNull(name, "name");
        Objects.requireNonNull(category, "category");
        if (name.isBlank()) {
            throw new IllegalArgumentException("Pattern name must not be blank");
        }
    }
}
