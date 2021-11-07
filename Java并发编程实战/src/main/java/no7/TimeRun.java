package no7;

import org.junit.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author Leesin Dong
 * @since 2021/11/7
 */
public class TimeRun {
    private final static ScheduledExecutorService executorService = (ScheduledExecutorService) Executors
            .newFixedThreadPool(10);

    @Test
    public void test() throws InterruptedException {
        ThrowableTask throwableTask = new ThrowableTask();
        Thread thread = new Thread(throwableTask);
        executorService.schedule(new Runnable() {
            @Override
            public void run() {
                thread.interrupt();
            }
        }, 10, TimeUnit.SECONDS);
        thread.join(10);
        // 异常可见性
        throwableTask.reThrow();
    }

    private static class ThrowableTask implements Runnable {
        private volatile Throwable throwable;

        @Override
        public void run() {
            try {
                System.out.println("aaa");
                throw new RuntimeException();
            } catch (RuntimeException e) {
                throwable = e;
            }
        }

        void reThrow() {
            if (throwable != null) {
                throw new RuntimeException(throwable);
            }
        }
    }
}
