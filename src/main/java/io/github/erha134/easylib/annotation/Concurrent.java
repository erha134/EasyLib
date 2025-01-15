package io.github.erha134.easylib.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 并发注解，用于标记可以并发处理的类、方法等。
 */
@Retention(RetentionPolicy.SOURCE)
public @interface Concurrent {
}
