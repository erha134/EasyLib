package io.github.erha134.easylib.schedule;

import io.github.erha134.easylib.annotation.Async;

import java.util.concurrent.*;

/**
 * 任务执行器，参考 Bukkit API。
 */
public final class Scheduler {
    private static final ExecutorService CACHED_POOL = Executors.newCachedThreadPool();
    private static final ScheduledExecutorService SCHEDULED_POOL = Executors.newScheduledThreadPool(1);

    public static void runTask(Runnable task) {
        task.run();
    }

    @Async
    public static void runTaskAsync(Runnable task) {
        CompletableFuture.runAsync(task, CACHED_POOL);
    }

    @Async
    public static void runTaskLater(Runnable task, long delay) {
        runTaskLater(task, delay, TimeUnit.SECONDS);
    }

    @Async
    public static void runTaskLater(Runnable task, long delay, TimeUnit unit) {
        SCHEDULED_POOL.schedule(task, delay, unit);
    }

//    @Async
//    public static CompletableFuture<Void> runTaskLaterAsync(Runnable task, long delay) {
//        return runTaskLaterAsync(task, delay, TimeUnit.SECONDS);
//    }
//
//    @Async
//    public static CompletableFuture<Void> runTaskLaterAsync(Runnable task, long delay, TimeUnit unit) {
//        return CompletableFuture.runAsync(() -> SCHEDULED_POOL.schedule(task, delay, unit));
//    }

    @Async
    public static void runTaskTimer(Runnable task, long delay, long period) {
        runTaskTimer(task, delay, period, TimeUnit.SECONDS);
    }

    @Async
    public static void runTaskTimer(Runnable task, long delay, long period, TimeUnit unit) {
        SCHEDULED_POOL.scheduleAtFixedRate(task, delay, period, unit);
    }

//    @Async
//    public static CompletableFuture<Void> runTaskTimerAsync(Runnable task, long delay, long period) {
//        return runTaskTimerAsync(task, delay, period, TimeUnit.SECONDS);
//    }
//
//    @Async
//    public static CompletableFuture<Void> runTaskTimerAsync(Runnable task, long delay, long period, TimeUnit unit) {
//        return CompletableFuture.runAsync(() -> SCHEDULED_POOL.scheduleAtFixedRate(task, delay, period, unit));
//    }
}
