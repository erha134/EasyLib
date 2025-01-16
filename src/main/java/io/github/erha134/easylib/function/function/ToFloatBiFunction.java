package io.github.erha134.easylib.function.function;

@FunctionalInterface
public interface ToFloatBiFunction<T, U> {
    float applyAsFloat(T t, U u);
}
