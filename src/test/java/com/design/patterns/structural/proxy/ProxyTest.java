package com.design.patterns.structural.proxy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Map;
import org.junit.jupiter.api.Test;

class ProxyTest {
    @Test
    void authorizedProxyDelegates() {
        DocumentService target = new InMemoryDocuments(Map.of("doc", "secret"));
        assertEquals("secret", new AuthorizedDocumentProxy(target, true).read("doc"));
        assertThrows(IllegalArgumentException.class,
                () -> new AuthorizedDocumentProxy(target, true).read("missing"));
    }

    @Test
    void unauthorizedProxyRejectsBeforeCallingTarget() {
        DocumentService failIfCalled = key -> {
            throw new AssertionError("Target must not be called");
        };
        assertThrows(SecurityException.class,
                () -> new AuthorizedDocumentProxy(failIfCalled, false).read("doc"));
        assertThrows(NullPointerException.class, () -> new AuthorizedDocumentProxy(null, true));
    }
}
