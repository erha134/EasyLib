package io.github.erha134.easylib.schedule;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SchedulerTest {
    private static void execute() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException ignored) {
        }

        System.err.println("Hello World");
    }

    @Test
    void runTask() {
        Scheduler.runTask(SchedulerTest::execute);
    }

    @Test
    void runTaskAsync() throws InterruptedException {
        Scheduler.runTaskAsync(SchedulerTest::execute);
        Thread.sleep(1000);
    }

    @Test
    void runTaskLater() throws InterruptedException {
        Scheduler.runTaskLater(SchedulerTest::execute, 1);
        Thread.sleep(2000);
    }

    @Test
    void runTaskTimer() throws InterruptedException {
        Scheduler.runTaskTimer(SchedulerTest::execute, 1, 2);
        Thread.sleep(7500);
    }
}
