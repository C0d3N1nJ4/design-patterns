package com.design.patterns.behavioral.memento;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

/** Editor preserves text snapshots without exposing writable internal state. */
public final class MementoExample {
    private MementoExample() {
    }

    public record Snapshot(String text) {
        public Snapshot {
            Objects.requireNonNull(text, "text");
        }
    }

    public static final class Editor {
        private String text = "";

        public void write(String value) {
            text = Objects.requireNonNull(value, "value");
        }

        public String text() {
            return text;
        }

        public Snapshot save() {
            return new Snapshot(text);
        }

        public void restore(Snapshot snapshot) {
            text = Objects.requireNonNull(snapshot, "snapshot").text();
        }
    }

    public static final class History {
        private final Deque<Snapshot> snapshots = new ArrayDeque<>();

        public void remember(Editor editor) {
            snapshots.push(Objects.requireNonNull(editor, "editor").save());
        }

        public void undo(Editor editor) {
            Objects.requireNonNull(editor, "editor");
            if (snapshots.isEmpty()) {
                throw new IllegalStateException("No saved snapshot");
            }
            editor.restore(snapshots.pop());
        }
    }
}
