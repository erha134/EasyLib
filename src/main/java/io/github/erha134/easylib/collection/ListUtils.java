package io.github.erha134.easylib.collection;

import io.github.erha134.easylib.util.EnumerationUtils;
import io.github.erha134.easylib.util.IterateUtils;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public final class ListUtils {
    // ArrayList
    public static <T> ArrayList<T> newArrayList() {
        return new ArrayList<>();
    }

    @SafeVarargs
    public static <T> ArrayList<T> newArrayList(T... elements) {
        return new ArrayList<>(Arrays.asList(elements));
    }

    public static <T> ArrayList<T> newArrayList(Iterable<T> it) {
        final ArrayList<T> list = newArrayList();
        IterateUtils.toStream(it).forEach(list::add);
        return list;
    }

    public static <T> ArrayList<T> newArrayList(Iterator<T> it) {
        final ArrayList<T> list = newArrayList();
        IterateUtils.toStream(it).forEach(list::add);
        return list;
    }

    public static <T> ArrayList<T> newArrayList(Enumeration<T> enumeration) {
        return newArrayList(EnumerationUtils.toIterator(enumeration));
    }

    // LinkedList
    public static <T> LinkedList<T> newLinkedList() {
        return new LinkedList<>();
    }

    @SafeVarargs
    public static <T> LinkedList<T> newLinkedList(T... elements) {
        return new LinkedList<>(Arrays.asList(elements));
    }

    public static <T> LinkedList<T> newLinkedList(Iterable<T> it) {
        final LinkedList<T> list = newLinkedList();
        IterateUtils.toStream(it).forEach(list::add);
        return list;
    }

    public static <T> LinkedList<T> newLinkedList(Iterator<T> it) {
        final LinkedList<T> list = newLinkedList();
        IterateUtils.toStream(it).forEach(list::add);
        return list;
    }

    public static <T> LinkedList<T> newLinkedList(Enumeration<T> enumeration) {
        return newLinkedList(EnumerationUtils.toIterator(enumeration));
    }

    // CopyOnWriteArrayList
    public static <T> CopyOnWriteArrayList<T> newCopyOnWriteArrayList() {
        return new CopyOnWriteArrayList<>();
    }

    @SafeVarargs
    public static <T> CopyOnWriteArrayList<T> newCopyOnWriteArrayList(T... elements) {
        return new CopyOnWriteArrayList<>(Arrays.asList(elements));
    }

    public static <T> CopyOnWriteArrayList<T> newCopyOnWriteArrayList(Iterable<T> it) {
        final CopyOnWriteArrayList<T> list = newCopyOnWriteArrayList();
        IterateUtils.toStream(it).forEach(list::add);
        return list;
    }

    public static <T> CopyOnWriteArrayList<T> newCopyOnWriteArrayList(Iterator<T> it) {
        final CopyOnWriteArrayList<T> list = newCopyOnWriteArrayList();
        IterateUtils.toStream(it).forEach(list::add);
        return list;
    }

    public static <T> CopyOnWriteArrayList<T> newCopyOnWriteArrayList(Enumeration<T> enumeration) {
        return newCopyOnWriteArrayList(EnumerationUtils.toIterator(enumeration));
    }
}
