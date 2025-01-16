package io.github.erha134.easylib.util.optional;

import io.github.erha134.easylib.function.consumer.CharConsumer;
import io.github.erha134.easylib.function.supplier.CharSupplier;

import java.util.NoSuchElementException;
import java.util.function.Supplier;

public final class OptionalChar implements CharSupplier {
    private static final OptionalChar EMPTY = new OptionalChar();

    private final boolean isPresent;
    private final char value;

    private OptionalChar() {
        this.isPresent = false;
        this.value = 0;
    }

    public static OptionalChar empty() {
        return EMPTY;
    }

    private OptionalChar(char value) {
        this.isPresent = true;
        this.value = value;
    }

    public static OptionalChar of(char value) {
        return new OptionalChar(value);
    }

    @Override
    public char getAsChar() {
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

    public void ifPresent(CharConsumer action) {
        if (isPresent) {
            action.accept(value);
        }
    }

    public void ifPresentOrElse(CharConsumer action, Runnable emptyAction) {
        if (isPresent) {
            action.accept(value);
        } else {
            emptyAction.run();
        }
    }

    public float orElse(float other) {
        return isPresent ? value : other;
    }

    public float orElseGet(CharSupplier supplier) {
        return isPresent ? value : supplier.getAsChar();
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

        if (obj instanceof OptionalChar) {
            OptionalChar other = (OptionalChar) obj;

            return isPresent && other.isPresent
                    ? value == other.value
                    : isPresent == other.isPresent;
        }

        return false;
    }

    @Override
    public int hashCode() {
        return isPresent ? Character.hashCode(value) : 0;
    }

    @Override
    public String toString() {
        return isPresent ? String.format("OptionalChar[%s]", value) : "OptionalChar.empty";
    }
}
