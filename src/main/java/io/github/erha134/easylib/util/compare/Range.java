package io.github.erha134.easylib.util.compare;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = false)
@EqualsAndHashCode(callSuper = false)
public final class Range<T extends Comparable<T>> {
    private final T min;
    private final T max;

    public Range(T min, T max) {
        if (min.compareTo(max) > 0) {
            throw new IllegalArgumentException("min > max");
        }

        this.min = min;
        this.max = max;
    }

    public boolean contains(T t) {
        return t.compareTo(this.min) >= 0 &&
                t.compareTo(this.max) <= 0;
    }

    public boolean contains(Range<T> other) {
        return other.min.compareTo(this.min) >= 0 &&
                other.max.compareTo(this.max) <= 0;
    }
}
