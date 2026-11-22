package com.design.patterns.enterprise.specification;

import java.util.Objects;
import java.util.function.Predicate;

/** Composable in-memory domain predicates; not a database query builder. */
@FunctionalInterface
public interface Specification<T> {
    boolean isSatisfiedBy(T candidate);

    default Specification<T> and(Specification<T> other) {
        Objects.requireNonNull(other, "other");
        return value -> isSatisfiedBy(value) && other.isSatisfiedBy(value);
    }

    default Specification<T> or(Specification<T> other) {
        Objects.requireNonNull(other, "other");
        return value -> isSatisfiedBy(value) || other.isSatisfiedBy(value);
    }

    default Specification<T> not() {
        return value -> !isSatisfiedBy(value);
    }

    static <T> Specification<T> from(Predicate<T> predicate) {
        Objects.requireNonNull(predicate, "predicate");
        return predicate::test;
    }
}
