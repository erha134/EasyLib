package io.github.erha134.easylib.function.function;

@FunctionalInterface
public interface ToCharBiFunction<T, U> {
    char applyAsChar(T t, U u);
}
