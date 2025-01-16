package io.github.erha134.easylib.lazy;

import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

/**
 * 懒加载，参考 Forge 代码。
 * @param <T> 返回类型
 */
public interface Lazy<T> extends Supplier<T> {
    /**
     * 创建懒加载对象。
     * @param supplier {@link Supplier} 包装后的需要懒加载的对象
     * @return 懒加载对象
     * @param <T> 返回类型
     */
    static <T> Lazy<T> of(@NotNull Supplier<T> supplier) {
        return new Lazy.Impl<>(supplier);
    }

    /**
     * 创建并发安全的懒加载对象。
     * @param supplier {@link Supplier} 包装后的需要懒加载的对象
     * @return 懒加载对象
     * @param <T> 返回类型
     */
    static <T> Lazy<T> ofConcurrent(@NotNull Supplier<T> supplier) {
        return new Lazy.Concurrent<>(supplier);
    }

    /**
     * 懒加载对象实现，不保证线程安全。
     * @param <T> 返回类型
     */
    @ApiStatus.NonExtendable
    final class Impl<T> implements Lazy<T> {
        private Supplier<T> supplier;
        @Nullable
        private T instance;

        private Impl(Supplier<T> supplier) {
            this.supplier = supplier;
        }

        @Nullable
        @Override
        public T get() {
            if (this.supplier != null) {
                this.instance = this.supplier.get();

                // clear
                this.supplier = null;
            }

            return this.instance;
        }
    }

    /**
     * 懒加载对象实现，保证线程安全。
     * @param <T> 返回类型
     */
    @io.github.erha134.easylib.annotation.Concurrent
    @ApiStatus.NonExtendable
    final class Concurrent<T> implements Lazy<T> {
        private volatile Object lock = new Object();
        private volatile Supplier<T> supplier;
        @Nullable
        private volatile T instance;

        private Concurrent(Supplier<T> supplier) {
            this.supplier = supplier;
        }

        @Nullable
        @Override
        public T get() {
            Object localLock = this.lock;
            if (this.supplier != null) {
                synchronized (localLock) {
                    if (this.supplier != null) {
                        this.instance = this.supplier.get();

                        // clear
                        this.supplier = null;
                        this.lock = null;
                    }
                }
            }

            return this.instance;
        }
    }
}
