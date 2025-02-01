package io.github.erha134.easylib.collection.set;

import org.jetbrains.annotations.ApiStatus;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashSet<E> extends AbstractSet<E> implements Set<E> {
    transient ConcurrentHashMap<E, Object> map;

    // Dummy
    static final Object PRESENT = new Object();

    public ConcurrentHashSet() {
        this.map = new ConcurrentHashMap<>();
    }

    public ConcurrentHashSet(Collection<? extends E> c) {
        this();
        addAll(c);
    }

    public ConcurrentHashSet(int initialCapacity, float loadFactor) {
        this.map = new ConcurrentHashMap<>(initialCapacity, loadFactor);
    }

    public ConcurrentHashSet(int initialCapacity) {
        this.map = new ConcurrentHashMap<>(initialCapacity);
    }

    @Override
    public Iterator<E> iterator() {
        return this.map.keySet().iterator();
    }

    @Override
    public int size() {
        return this.map.size();
    }

    @Override
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return this.map.containsKey(o);
    }

    @Override
    public boolean add(E e) {
        return this.map.put(e, PRESENT)==null;
    }

    @Override
    public boolean remove(Object o) {
        return this.map.remove(o)==PRESENT;
    }

    @Override
    public void clear() {
        this.map.clear();
    }

    @ApiStatus.Experimental
    @Override
    public Spliterator<E> spliterator() {
        return Spliterators.spliteratorUnknownSize(this.iterator(),
                Spliterator.DISTINCT | Spliterator.CONCURRENT | Spliterator.NONNULL);
    }

    @ApiStatus.Experimental
    @Override
    public Object[] toArray() {
        return this.toArray(new Object[this.size()]);
    }

    @ApiStatus.Experimental
    @Override
    public <T> T[] toArray(T[] a) {
        int i = 0;
        for (E e : this.map.keySet()) {
            ((Object[]) a)[i++] = e;
        }

        return a;
    }

    private <T> T[] prepareArray(T[] a) {
        int size = this.size();
        if (a.length < size) {
            return (T[]) Array.newInstance(a.getClass().getComponentType(), size);
        }
        if (a.length > size) {
            a[size] = null;
        }
        return a;
    }
}
