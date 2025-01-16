package io.github.erha134.easylib.function.consumer;

@FunctionalInterface
public interface ObjCharConsumer<T> {
    void accept(T t, char value);
}
