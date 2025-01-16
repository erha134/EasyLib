package io.github.erha134.easylib.function.predicate;

import java.util.Objects;

@FunctionalInterface
public interface FloatPredicate {
    boolean test(float value);

    default FloatPredicate and(FloatPredicate other) {
        Objects.requireNonNull(other);
        return value -> test(value) && other.test(value);
    }

    default FloatPredicate negate() {
        return value -> !test(value);
    }

    default FloatPredicate or(FloatPredicate other) {
        Objects.requireNonNull(other);
        return value -> test(value) || other.test(value);
    }
}
