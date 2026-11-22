package com.design.patterns.structural.flyweight;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/** Shares immutable style attributes; positions remain outside the flyweight. */
public final class TextStyleFactory {
    private final Map<StyleKey, TextStyle> cache = new ConcurrentHashMap<>();

    public TextStyle style(String family, int size) {
        if (family == null || family.isBlank() || size <= 0) {
            throw new IllegalArgumentException("invalid style");
        }
        return cache.computeIfAbsent(new StyleKey(family, size),
                key -> new TextStyle(key.family(), key.size()));
    }

    public int cachedStyles() {
        return cache.size();
    }

    private record StyleKey(String family, int size) {
    }

    public record TextStyle(String fontFamily, int fontSize) {
        public TextStyle {
            Objects.requireNonNull(fontFamily, "fontFamily");
            if (fontFamily.isBlank() || fontSize <= 0) {
                throw new IllegalArgumentException("invalid style");
            }
        }

        public String render(char character, int position) {
            return character + "@" + position + " [" + fontFamily + "/" + fontSize + "]";
        }
    }
}
