package io.github.erha134.easylib.function.consumer;

@FunctionalInterface
public interface TripleConsumer<T, U, V> {
    void accept(T t, U u, V v);
}
