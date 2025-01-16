package io.github.erha134.easylib.function.function;

@FunctionalInterface
public interface ToFloatFunction<T> {
    float applyAsFloat(T value);
}
