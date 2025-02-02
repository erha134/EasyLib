package io.github.erha134.easylib.collection;

import io.github.erha134.easylib.stream.StreamUtils;
import io.github.erha134.easylib.util.EnumerationUtils;
import io.github.erha134.easylib.util.IterateUtils;

import java.util.*;
import java.util.stream.Stream;

public class ListUtils {
    public static <T> List<T> of() {
        return of(false);
    }

    @SafeVarargs
    public static <T> List<T> of(T... elements) {
        return of(false, elements);
    }

    public static <T> List<T> of(Collection<? extends T> elements) {
        return of(false, elements);
    }

    public static <T> List<T> of(Enumeration<? extends T> enumeration) {
        return of(false, enumeration);
    }

    public static <T> List<T> of(Iterable<? extends T> it) {
        return of(false, it);
    }

    public static <T> List<T> of(Iterator<? extends T> it) {
        return of(false, it);
    }

    public static <T> List<T> of(Stream<? extends T> stream) {
        return of(false, stream);
    }

    public static <T> List<T> of(boolean linked) {
        return linked ? new LinkedList<>() : new ArrayList<>();
    }

    @SafeVarargs
    public static <T> List<T> of(boolean linked, T... elements) {
        if (linked) {
            return new LinkedList<>(Arrays.asList(elements));
        }

        return new ArrayList<>(Arrays.asList(elements));
    }

    public static <T> List<T> of(boolean linked, Collection<? extends T> elements) {
        if (linked) {
            return new LinkedList<>(elements);
        }

        return new ArrayList<>(elements);
    }

    public static <T> List<T> of(boolean linked, Enumeration<? extends T> enumeration) {
        return of(linked, EnumerationUtils.toIterator(enumeration));
    }

    public static <T> List<T> of(boolean linked, Iterable<? extends T> it) {
        return of(linked, IterateUtils.toStream(it));
    }

    public static <T> List<T> of(boolean linked, Iterator<? extends T> it) {
        return of(linked, IterateUtils.toStream(it));
    }

    public static <T> List<T> of(boolean linked, Stream<? extends T> stream) {
        return of(linked, StreamUtils.toList(stream));
    }
}
