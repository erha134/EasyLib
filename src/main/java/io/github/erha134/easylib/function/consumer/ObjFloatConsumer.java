package io.github.erha134.easylib.function.consumer;

@FunctionalInterface
public interface ObjFloatConsumer<T> {
    void accept(T t, float value);
}
