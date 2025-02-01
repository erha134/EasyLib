package io.github.erha134.easylib.collection;

import io.github.erha134.easylib.collection.set.ConcurrentHashSet;
import io.github.erha134.easylib.util.EnumerationUtils;
import io.github.erha134.easylib.util.IterateUtils;

import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;

public class SetUtils {
    // HashSet
    public static <T> HashSet<T> newHashSet() {
        return new HashSet<>();
    }

    @SafeVarargs
    public static <T> HashSet<T> newHashSet(T... elements) {
        return new HashSet<>(Arrays.asList(elements));
    }

    public static <T> HashSet<T> newHashSet(Iterable<T> it) {
        final HashSet<T> set = newHashSet();
        IterateUtils.toStream(it).forEach(set::add);
        return set;
    }

    public static <T> HashSet<T> newHashSet(Iterator<T> it) {
        final HashSet<T> set = newHashSet();
        IterateUtils.toStream(it).forEach(set::add);
        return set;
    }

    public static <T> HashSet<T> newHashSet(Enumeration<T> enumeration) {
        return newHashSet(EnumerationUtils.toIterator(enumeration));
    }

    // LinkedHashSet
    public static <T> LinkedHashSet<T> newLinkedHashSet() {
        return new LinkedHashSet<>();
    }

    @SafeVarargs
    public static <T> LinkedHashSet<T> newLinkedHashSet(T... elements) {
        return new LinkedHashSet<>(Arrays.asList(elements));
    }

    public static <T> LinkedHashSet<T> newLinkedHashSet(Iterable<T> it) {
        final LinkedHashSet<T> set = newLinkedHashSet();
        IterateUtils.toStream(it).forEach(set::add);
        return set;
    }

    public static <T> LinkedHashSet<T> newLinkedHashSet(Iterator<T> it) {
        final LinkedHashSet<T> set = newLinkedHashSet();
        IterateUtils.toStream(it).forEach(set::add);
        return set;
    }

    public static <T> LinkedHashSet<T> newLinkedHashSet(Enumeration<T> enumeration) {
        return newLinkedHashSet(EnumerationUtils.toIterator(enumeration));
    }


    // CopyOnWriteArraySet
    public static <T> CopyOnWriteArraySet<T> newCopyOnWriteArraySet() {
        return new CopyOnWriteArraySet<>();
    }

    @SafeVarargs
    public static <T> CopyOnWriteArraySet<T> newCopyOnWriteArraySet(T... elements) {
        return new CopyOnWriteArraySet<>(Arrays.asList(elements));
    }

    public static <T> CopyOnWriteArraySet<T> newCopyOnWriteArraySet(Iterable<T> it) {
        final CopyOnWriteArraySet<T> set = newCopyOnWriteArraySet();
        IterateUtils.toStream(it).forEach(set::add);
        return set;
    }

    public static <T> CopyOnWriteArraySet<T> newCopyOnWriteArraySet(Iterator<T> it) {
        final CopyOnWriteArraySet<T> set = newCopyOnWriteArraySet();
        IterateUtils.toStream(it).forEach(set::add);
        return set;
    }

    public static <T> CopyOnWriteArraySet<T> newCopyOnWriteArraySet(Enumeration<T> enumeration) {
        return newCopyOnWriteArraySet(EnumerationUtils.toIterator(enumeration));
    }

    // ConcurrentHashSet
    public static <T> ConcurrentHashSet<T> newConcurrentHashSet() {
        return new ConcurrentHashSet<>();
    }

    @SafeVarargs
    public static <T> ConcurrentHashSet<T> newConcurrentHashSet(T... elements) {
        return new ConcurrentHashSet<>(Arrays.asList(elements));
    }

    public static <T> ConcurrentHashSet<T> newConcurrentHashSet(Iterable<T> it) {
        final ConcurrentHashSet<T> set = newConcurrentHashSet();
        IterateUtils.toStream(it).forEach(set::add);
        return set;
    }

    public static <T> ConcurrentHashSet<T> newConcurrentHashSet(Iterator<T> it) {
        final ConcurrentHashSet<T> set = newConcurrentHashSet();
        IterateUtils.toStream(it).forEach(set::add);
        return set;
    }

    public static <T> ConcurrentHashSet<T> newConcurrentHashSet(Enumeration<T> enumeration) {
        return newConcurrentHashSet(EnumerationUtils.toIterator(enumeration));
    }
}
