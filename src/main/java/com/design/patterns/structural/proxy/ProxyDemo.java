package com.design.patterns.structural.proxy;

import java.util.Map;

public final class ProxyDemo {
    private ProxyDemo() {
    }

    public static void main(String[] args) {
        DocumentService docs = new AuthorizedDocumentProxy(
                new InMemoryDocuments(Map.of("POLICY-1", "Internal policy")), true);
        System.out.println(docs.read("POLICY-1"));
    }
}
