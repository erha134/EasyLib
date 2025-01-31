package io.github.erha134.easylib.function.predicate;

@FunctionalInterface
public interface QuadPredicate<T, U, V, W> {
    boolean test(T t, U u, V v, W w);
}
