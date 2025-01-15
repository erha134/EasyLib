package io.github.erha134.easylib.string;

import org.jetbrains.annotations.Nullable;

/**
 * 字符串工具类
 */
public class StringUtils {
    /**
     * 判断字符串是否为空（{@code null} 也为空）。
     * @param s 字符串
     * @return 是否为空
     */
    public static boolean isEmpty(String s) {
        return s == null || s.isEmpty();
    }

    /**
     * 将对象转换为字符串，包装了 {@link String#valueOf(Object)}。
     * @param o 对象
     * @return 字符串
     * @see String#valueOf(Object)
     */
    public static String toString(@Nullable Object o) {
        return String.valueOf(o);
    }
}
