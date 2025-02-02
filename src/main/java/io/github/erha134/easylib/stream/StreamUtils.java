package io.github.erha134.easylib.stream;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamUtils {
    public static <T> List<T> toList(Stream<T> stream) {
        return stream.collect(Collectors.toList());
    }

    public static <T> Set<T> toSet(Stream<T> stream) {
        return stream.collect(Collectors.toSet());
    }

    @SuppressWarnings("unchecked")
    public static <T> T[] toArray(Stream<T> stream, Class<T> clazz) {
        return stream.toArray(i -> (T[]) Array.newInstance(clazz, i));
    }
}
