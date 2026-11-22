package com.design.patterns.behavioral.interpreter;

import java.util.Objects;
import java.util.Set;

/** A small boolean expression grammar: literal, NOT, AND, OR. */
public final class InterpreterExample {
    private InterpreterExample() {
    }

    public interface Expression {
        boolean evaluate(Set<String> facts);
    }

    public record Variable(String name) implements Expression {
        public Variable {
            if (name == null || name.isBlank()) {
                throw new IllegalArgumentException("name must not be blank");
            }
        }

        @Override
        public boolean evaluate(Set<String> facts) {
            return Objects.requireNonNull(facts, "facts").contains(name);
        }
    }

    public record Not(Expression operand) implements Expression {
        public Not {
            Objects.requireNonNull(operand, "operand");
        }

        @Override
        public boolean evaluate(Set<String> facts) {
            return !operand.evaluate(facts);
        }
    }

    public record And(Expression left, Expression right) implements Expression {
        public And {
            Objects.requireNonNull(left, "left");
            Objects.requireNonNull(right, "right");
        }

        @Override
        public boolean evaluate(Set<String> facts) {
            return left.evaluate(facts) && right.evaluate(facts);
        }
    }

    public record Or(Expression left, Expression right) implements Expression {
        public Or {
            Objects.requireNonNull(left, "left");
            Objects.requireNonNull(right, "right");
        }

        @Override
        public boolean evaluate(Set<String> facts) {
            return left.evaluate(facts) || right.evaluate(facts);
        }
    }
}
