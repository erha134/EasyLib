package io.github.erha134.easylib.array;

import org.jetbrains.annotations.Nullable;

/**
 * 数组工具类。
 */
public class ArrayUtils {
    public static <T> boolean isEmpty(@Nullable T[] array) {
        return array == null || array.length == 0;
    }

    public static boolean isEmpty(@Nullable boolean[] array) {
        return array == null || array.length == 0;
    }

    public static boolean isEmpty(@Nullable byte[] array) {
        return array == null || array.length == 0;
    }

    public static boolean isEmpty(@Nullable char[] array) {
        return array == null || array.length == 0;
    }

    public static boolean isEmpty(@Nullable short[] array) {
        return array == null || array.length == 0;
    }

    public static boolean isEmpty(@Nullable int[] array) {
        return array == null || array.length == 0;
    }

    public static boolean isEmpty(@Nullable long[] array) {
        return array == null || array.length == 0;
    }

    public static boolean isEmpty(@Nullable float[] array) {
        return array == null || array.length == 0;
    }

    public static boolean isEmpty(@Nullable double[] array) {
        return array == null || array.length == 0;
    }
}
