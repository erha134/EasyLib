package io.github.erha134.easylib.function;

import java.util.function.Function;
import java.util.function.Supplier;

public class FunctionalUtils {
    public static <T> Function<Void, T> toFunction(Supplier<T> supplier) {
        return unused -> supplier.get();
    }

    public static <T> Supplier<T> toSupplier(Function<Void, T> function) {
        return () -> function.apply(null);
    }
}
