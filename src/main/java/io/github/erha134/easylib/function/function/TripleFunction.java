package io.github.erha134.easylib.function.function;

@FunctionalInterface
public interface TripleFunction<T, U, V, R> {
    R apply(T t, U u, V v);
}
