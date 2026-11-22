package com.design.patterns.behavioral.state;

import java.util.Objects;

/** A document delegates permitted transitions to its current state. */
public final class StateExample {
    private StateExample() {
    }

    public interface State {
        String name();

        State submit();

        State approve();
    }

    public static final class Draft implements State {
        @Override
        public String name() {
            return "Draft";
        }

        @Override
        public State submit() {
            return new Pending();
        }

        @Override
        public State approve() {
            throw new IllegalStateException("Submit before approval");
        }
    }

    public static final class Pending implements State {
        @Override
        public String name() {
            return "Pending";
        }

        @Override
        public State submit() {
            throw new IllegalStateException("Already submitted");
        }

        @Override
        public State approve() {
            return new Approved();
        }
    }

    public static final class Approved implements State {
        @Override
        public String name() {
            return "Approved";
        }

        @Override
        public State submit() {
            throw new IllegalStateException("Already approved");
        }

        @Override
        public State approve() {
            throw new IllegalStateException("Already approved");
        }
    }

    public static final class Document {
        private State state = new Draft();

        public String status() {
            return state.name();
        }

        public void submit() {
            state = Objects.requireNonNull(state.submit(), "state");
        }

        public void approve() {
            state = Objects.requireNonNull(state.approve(), "state");
        }
    }
}
