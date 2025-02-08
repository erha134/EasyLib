package io.github.erha134.easylib.util;

import io.github.erha134.easylib.stream.StreamUtils;

import java.util.Iterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * 迭代工具类。
 */
public class IterateUtils extends StreamUtils {
    /**
     * 将迭代器转换为 {@link Stream}。
     * @param it 迭代器
     * @return 转换后的 {@link Stream}
     * @param <T> 迭代器元素类型
     */
    public static <T> Stream<T> toStream(Iterator<T> it) {
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(it, 0), false);
    }

    /**
     * 将迭代器转换为并行的 {@link Stream}。
     * @param it 迭代器
     * @return 转换后的 {@link Stream}
     * @param <T> 迭代器元素类型
     */
    public static <T> Stream<T> toStreamParalleled(Iterator<T> it) {
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(it, 0), true);
    }

    /**
     * 将可迭代对象转换为 {@link Stream}。
     * @param it 可迭代对象
     * @return 转换后的 {@link Stream}
     * @param <T> 可迭代对象元素类型
     */
    public static <T> Stream<T> toStream(Iterable<T> it) {
        return StreamSupport.stream(it.spliterator(), false);
    }

    /**
     * 将可迭代对象转换为并行的 {@link Stream}。
     * @param it 可迭代对象
     * @return 转换后的 {@link Stream}
     * @param <T> 可迭代对象元素类型
     */
    public static <T> Stream<T> toStreamParalleled(Iterable<T> it) {
        return StreamSupport.stream(it.spliterator(), true);
    }
}
