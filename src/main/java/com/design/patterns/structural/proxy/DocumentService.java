package com.design.patterns.structural.proxy;

import java.util.Map;
import java.util.Objects;

/** A proxy checks authorization before accessing a protected service. */
public interface DocumentService {
    String read(String documentId);
}

final class InMemoryDocuments implements DocumentService {
    private final Map<String, String> documents;

    InMemoryDocuments(Map<String, String> documents) {
        this.documents = Map.copyOf(documents);
    }

    @Override
    public String read(String documentId) {
        Objects.requireNonNull(documentId, "documentId");
        var content = documents.get(documentId);
        if (content == null) {
            throw new IllegalArgumentException("Unknown document: " + documentId);
        }
        return content;
    }
}

final class AuthorizedDocumentProxy implements DocumentService {
    private final DocumentService delegate;
    private final boolean allowed;

    AuthorizedDocumentProxy(DocumentService delegate, boolean allowed) {
        this.delegate = Objects.requireNonNull(delegate, "delegate");
        this.allowed = allowed;
    }

    @Override
    public String read(String documentId) {
        if (!allowed) {
            throw new SecurityException("Access denied");
        }
        return delegate.read(documentId);
    }
}
