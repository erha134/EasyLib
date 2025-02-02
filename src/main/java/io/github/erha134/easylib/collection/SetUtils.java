package io.github.erha134.easylib.collection;

import io.github.erha134.easylib.stream.StreamUtils;
import io.github.erha134.easylib.util.EnumerationUtils;
import io.github.erha134.easylib.util.IterateUtils;

import java.util.*;
import java.util.stream.Stream;

public class SetUtils {
    public static <T> Set<T> of() {
        return of(false);
    }

    @SafeVarargs
    public static <T> Set<T> of(T... elements) {
        return of(false, elements);
    }

    public static <T> Set<T> of(Collection<? extends T> elements) {
        return of(false, elements);
    }

    public static <T> Set<T> of(Enumeration<? extends T> enumeration) {
        return of(false, enumeration);
    }

    public static <T> Set<T> of(Iterable<? extends T> it) {
        return of(false, it);
    }

    public static <T> Set<T> of(Iterator<? extends T> it) {
        return of(false, it);
    }

    public static <T> Set<T> of(Stream<? extends T> stream) {
        return of(false, stream);
    }

    public static <T> Set<T> of(boolean linked) {
        return linked ? new LinkedHashSet<>() : new HashSet<>();
    }

    @SafeVarargs
    public static <T> Set<T> of(boolean linked, T... elements) {
        if (linked) {
            return new LinkedHashSet<>(Arrays.asList(elements));
        }

        return new HashSet<>(Arrays.asList(elements));
    }

    public static <T> Set<T> of(boolean linked, Collection<? extends T> elements) {
        if (linked) {
            return new LinkedHashSet<>(elements);
        }

        return new HashSet<>(elements);
    }

    public static <T> Set<T> of(boolean linked, Enumeration<? extends T> enumeration) {
        return of(linked, EnumerationUtils.toIterator(enumeration));
    }

    public static <T> Set<T> of(boolean linked, Iterable<? extends T> it) {
        return of(linked, IterateUtils.toStream(it));
    }

    public static <T> Set<T> of(boolean linked, Iterator<? extends T> it) {
        return of(linked, IterateUtils.toStream(it));
    }

    public static <T> Set<T> of(boolean linked, Stream<? extends T> stream) {
        return of(linked, StreamUtils.toSet(stream));
    }
}
