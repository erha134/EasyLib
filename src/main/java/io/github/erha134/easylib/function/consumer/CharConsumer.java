package io.github.erha134.easylib.function.consumer;

import io.github.erha134.easylib.util.ObjectNullSafe;

@FunctionalInterface
public interface CharConsumer {
    void accept(char value);

    default CharConsumer andThen(CharConsumer after) {
        ObjectNullSafe.requireNonNull(after);
        return (char t) -> { accept(t); after.accept(t); };
    }
}
