package io.github.erha134.easylib.function.predicate;

import io.github.erha134.easylib.util.ObjectNullSafe;

@FunctionalInterface
public interface CharPredicate {
    boolean test(char value);

    default CharPredicate and(CharPredicate other) {
        ObjectNullSafe.requireNonNull(other);
        return value -> test(value) && other.test(value);
    }

    default CharPredicate negate() {
        return value -> !test(value);
    }

    default CharPredicate or(CharPredicate other) {
        ObjectNullSafe.requireNonNull(other);
        return value -> test(value) || other.test(value);
    }
}
