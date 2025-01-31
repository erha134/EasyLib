package io.github.erha134.easylib.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 不可修改注解，用于标记方法的返回值、字段的值、类等为不可修改的。
 */
@Retention(RetentionPolicy.SOURCE)
public @interface Immutable {
}
