package com.design.patterns.behavioral.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/** Hides the underlying collection behind the Iterable contract. */
public final class IteratorExample {
    private IteratorExample() {
    }

    public static final class Backlog implements Iterable<String> {
        private final List<String> tasks = new ArrayList<>();

        public Backlog add(String task) {
            if (task == null || task.isBlank()) {
                throw new IllegalArgumentException("task must not be blank");
            }
            tasks.add(task);
            return this;
        }

        @Override
        public Iterator<String> iterator() {
            return List.copyOf(tasks).iterator();
        }

        public int size() {
            return tasks.size();
        }
    }
}
