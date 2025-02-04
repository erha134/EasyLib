package io.github.erha134.easylib.function.supplier;

import org.jetbrains.annotations.Nullable;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public interface OptionalSupplier<T> extends Supplier<T> {
    OptionalSupplier<?> EMPTY = () -> null;

    static <T> OptionalSupplier<T> empty() {
        return (OptionalSupplier<T>) EMPTY;
    }

    @Nullable
    @Override
    T get();

    default boolean isPresent() {
        return this.get() != null;
    }

    default Optional<T> toOptional() {
        return Optional.ofNullable(this.get());
    }

    default void ifPresent(Consumer<? super T> action) {
        if (this.isPresent()) {
            action.accept(this.get());
        }
    }

    default void ifPresentOrElse(Consumer<? super T> action, Runnable emptyAction) {
        if (this.isPresent()) {
            action.accept(this.get());
        } else {
            emptyAction.run();
        }
    }

    default Stream<T> stream() {
        if (!this.isPresent()) {
            return Stream.empty();
        } else {
            return Stream.of(this.get());
        }
    }

    default T orElse(T other) {
        return this.isPresent() ? this.get() : other;
    }

    default T orElseGet(Supplier<? extends T> supplier) {
        return this.orElse(supplier.get());
    }

    default T orElseThrow() {
        return this.orElseThrow(new NoSuchElementException("No value present"));
    }

    default <X extends Throwable> T orElseThrow(X e) throws X {
        if (!this.isPresent()) {
            throw e;
        }

        return this.get();
    }

    default <X extends Throwable> T orElseThrow(Supplier<? extends X> exceptionSupplier) throws X {
        return this.orElseThrow(exceptionSupplier.get());
    }

    default <U> OptionalSupplier<U> map(Function<? super T, ? extends U> mapper) {
        if (!this.isPresent()) {
            return empty();
        }

        return () -> mapper.apply(this.get());
    }

    default <U> OptionalSupplier<U> flatMap(Function<? super T, ? extends OptionalSupplier<? extends U>> mapper) {
        if (!this.isPresent()) {
            return empty();
        }

        return (OptionalSupplier<U>) mapper.apply(this.get());
    }

    default OptionalSupplier<T> filter(Predicate<? super T> predicate) {
        if (!this.isPresent()) {
            return empty();
        }

        return predicate.test(this.get()) ? this : empty();
    }

    default OptionalSupplier<T> or(Supplier<? extends OptionalSupplier<? extends T>> supplier) {
        if (!this.isPresent()) {
            return (OptionalSupplier<T>) supplier.get();
        }

        return this;
    }
}
