package io.github.erha134.easylib.util.optional;

import io.github.erha134.easylib.function.consumer.FloatConsumer;
import io.github.erha134.easylib.function.supplier.FloatSupplier;

import java.util.NoSuchElementException;
import java.util.function.Supplier;

public final class OptionalFloat implements FloatSupplier {
    private static final OptionalFloat EMPTY = new OptionalFloat();

    private final boolean isPresent;
    private final float value;

    private OptionalFloat() {
        this.isPresent = false;
        this.value = 0;
    }

    public static OptionalFloat empty() {
        return EMPTY;
    }

    private OptionalFloat(float value) {
        this.isPresent = true;
        this.value = value;
    }

    public static OptionalFloat of(float value) {
        return new OptionalFloat(value);
    }

    @Override
    public float getAsFloat() {
        if (!isPresent) {
            throw new NoSuchElementException("No value present");
        }

        return value;
    }

    public boolean isPresent() {
        return isPresent;
    }

    public boolean isEmpty() {
        return !isPresent;
    }

    public void ifPresent(FloatConsumer action) {
        if (isPresent) {
            action.accept(value);
        }
    }

    public void ifPresentOrElse(FloatConsumer action, Runnable emptyAction) {
        if (isPresent) {
            action.accept(value);
        } else {
            emptyAction.run();
        }
    }

    public float orElse(float other) {
        return isPresent ? value : other;
    }

    public float orElseGet(FloatSupplier supplier) {
        return isPresent ? value : supplier.getAsFloat();
    }

    public float orElseThrow() {
        if (!isPresent) {
            throw new NoSuchElementException("No value present");
        }

        return value;
    }

    public <X extends Throwable> float orElseThrow(Supplier<? extends X> exceptionSupplier) throws X {
        if (isPresent) {
            return value;
        }

        throw exceptionSupplier.get();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof OptionalFloat) {
            OptionalFloat other = (OptionalFloat) obj;

            return isPresent && other.isPresent
                    ? value == other.value
                    : isPresent == other.isPresent;
        }

        return false;
    }

    @Override
    public int hashCode() {
        return isPresent ? Float.hashCode(value) : 0;
    }

    @Override
    public String toString() {
        return isPresent ? String.format("OptionalFloat[%s]", value) : "OptionalFloat.empty";
    }
}
