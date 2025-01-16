package io.github.erha134.easylib.function.function;

@FunctionalInterface
public interface ToCharFunction<T> {
    char applyAsChar(T value);
}
