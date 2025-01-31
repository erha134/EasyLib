package io.github.erha134.easylib.function.predicate;

@FunctionalInterface
public interface TriplePredicate<T, U, V> {
    boolean test(T t, U u, V v);
}
