package io.github.erha134.easylib.function.operator;

import io.github.erha134.easylib.util.ObjectNullSafe;

@FunctionalInterface
public interface FloatUnaryOperator {
    float applyAsFloat(float operand);

    default FloatUnaryOperator compose(FloatUnaryOperator before) {
        ObjectNullSafe.requireNonNull(before);
        return (float v) -> applyAsFloat(before.applyAsFloat(v));
    }

    default FloatUnaryOperator andThen(FloatUnaryOperator after) {
        ObjectNullSafe.requireNonNull(after);
        return (float t) -> after.applyAsFloat(applyAsFloat(t));
    }

    static FloatUnaryOperator identity() {
        return t -> t;
    }
}
