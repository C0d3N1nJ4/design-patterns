package com.design.patterns.behavioral.command;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

/** Encapsulates changes as commands so they can be undone. */
public final class CommandExample {
    private CommandExample() {
    }

    public interface Command {
        void execute();

        void undo();
    }

    public static final class Light {
        private boolean on;

        public boolean isOn() {
            return on;
        }

        public void setOn(boolean value) {
            on = value;
        }
    }

    public static final class SetLight implements Command {
        private final Light light;
        private final boolean desired;
        private boolean previous;
        private boolean executed;

        public SetLight(Light light, boolean desired) {
            this.light = Objects.requireNonNull(light, "light");
            this.desired = desired;
        }

        @Override
        public void execute() {
            if (executed) {
                throw new IllegalStateException("Command already executed");
            }
            previous = light.isOn();
            light.setOn(desired);
            executed = true;
        }

        @Override
        public void undo() {
            if (!executed) {
                throw new IllegalStateException("Command not executed");
            }
            light.setOn(previous);
            executed = false;
        }
    }

    public static final class Remote {
        private final Deque<Command> history = new ArrayDeque<>();

        public void submit(Command command) {
            Objects.requireNonNull(command, "command");
            command.execute();
            history.push(command);
        }

        public void undoLast() {
            if (history.isEmpty()) {
                throw new IllegalStateException("Nothing to undo");
            }
            history.pop().undo();
        }
    }
}
