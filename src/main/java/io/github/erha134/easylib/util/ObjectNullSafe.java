package io.github.erha134.easylib.util;

import io.github.erha134.easylib.string.StringFormatter;

import java.util.function.Supplier;

public final class ObjectNullSafe {
    public static <T> T requireNonNull(T obj) {
        if (obj == null) {
            throw new NullPointerException();
        }

        return obj;
    }

    public static <T> T requireNonNull(T obj, String message) {
        if (obj == null) {
            throw new NullPointerException(requireNonNull(message));
        }

        return obj;
    }

    public static <T> T requireNonNull(T obj, String message, Object... args) {
        return requireNonNull(obj, StringFormatter.format(message, args));
    }

    public static <T, X extends Throwable> T requireNonNull(T obj, X x) throws X {
        if (obj == null) {
            throw requireNonNull(x);
        }

        return obj;
    }

    public static <T, X extends Throwable> T requireNonNull(T obj, Supplier<X> supplier) throws X {
        return requireNonNull(obj, requireNonNull(supplier).get());
    }

    public static <T> T requireNonNullOrElse(T obj, T elseObj) {
        if (obj == null) {
            return requireNonNull(elseObj);
        }

        return obj;
    }

    public static <T> T requireNonNullOrElse(T obj, Supplier<T> elseObj) {
        if (obj == null) {
            return requireNonNull(requireNonNull(elseObj).get());
        }

        return obj;
    }
}
