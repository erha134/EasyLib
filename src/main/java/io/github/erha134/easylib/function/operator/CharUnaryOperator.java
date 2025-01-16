package io.github.erha134.easylib.function.operator;

import io.github.erha134.easylib.util.ObjectNullSafe;

@FunctionalInterface
public interface CharUnaryOperator {
    char applyAsChar(char operand);

    default CharUnaryOperator compose(CharUnaryOperator before) {
        ObjectNullSafe.requireNonNull(before);
        return (char v) -> applyAsChar(before.applyAsChar(v));
    }

    default CharUnaryOperator andThen(CharUnaryOperator after) {
        ObjectNullSafe.requireNonNull(after);
        return (char t) -> after.applyAsChar(applyAsChar(t));
    }

    static CharUnaryOperator identity() {
        return t -> t;
    }
}
