package com.design.patterns.structural.composite;

public final class CompositeDemo {
    private CompositeDemo() {
    }

    public static void main(String[] args) {
        FileNode files = new Directory()
                .add(new Document("readme.txt", 120))
                .add(new Directory().add(new Document("report.pdf", 880)));
        System.out.println("Total bytes: " + files.size());
    }
}
