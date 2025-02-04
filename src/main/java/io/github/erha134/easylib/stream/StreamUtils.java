package io.github.erha134.easylib.stream;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
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

    public static <K, V> Map<K, V> toMap(Stream<? extends Map.Entry<K, V>> stream) {
        return toMap(stream, Map.Entry::getKey, Map.Entry::getValue);
    }

    public static <T, K, V> Map<K, V> toMap(Stream<T> stream,
                                            Function<? super T, ? extends K> keyMapper,
                                            Function<? super T, ? extends V> valueMapper) {
        return stream.collect(Collectors.toMap(keyMapper, valueMapper));
    }
}
