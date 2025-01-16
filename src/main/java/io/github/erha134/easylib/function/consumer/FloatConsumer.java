package io.github.erha134.easylib.function.consumer;

import io.github.erha134.easylib.util.ObjectNullSafe;

@FunctionalInterface
public interface FloatConsumer {
    void accept(float value);

    default FloatConsumer andThen(FloatConsumer after) {
        ObjectNullSafe.requireNonNull(after);
        return (float t) -> { accept(t); after.accept(t); };
    }
}
