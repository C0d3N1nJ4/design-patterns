package com.design.patterns.structural.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** Treat a file or directory consistently when calculating total size. */
public sealed interface FileNode permits Document, Directory {
    long size();
}

record Document(String name, long bytes) implements FileNode {
    Document {
        Objects.requireNonNull(name, "name");
        if (name.isBlank() || bytes < 0) {
            throw new IllegalArgumentException("invalid document");
        }
    }

    @Override
    public long size() {
        return bytes;
    }
}

final class Directory implements FileNode {
    private final List<FileNode> children = new ArrayList<>();

    Directory add(FileNode child) {
        children.add(Objects.requireNonNull(child, "child"));
        return this;
    }

    @Override
    public long size() {
        return children.stream().mapToLong(FileNode::size).reduce(0L, Math::addExact);
    }
}
