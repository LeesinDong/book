package no8;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Leesin Dong
 * @since 2021/11/9
 */
@Slf4j
public class TimingThreadPool extends ThreadPoolExecutor {
    private final AtomicLong taskNum = new AtomicLong();
    private final AtomicLong timeNum = new AtomicLong();
    private static final ThreadLocal<Long> threadLocal = new ThreadLocal<Long>();

    public TimingThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
        log.info("start thread is: {} and runnable is: {} and time is: {}", t, r, System.nanoTime());
        threadLocal.set(System.nanoTime());
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        try {
            Long startTime = threadLocal.get();
            Long executeTime = System.nanoTime() - startTime;
            taskNum.getAndIncrement();
            timeNum.getAndAdd(executeTime);
            log.info("end runnable is: {} and executeTime is: {}", r, executeTime);
        } finally {
            super.afterExecute(r, t);
        }
    }

    @Override
    protected void terminated() {
        try {
            log.info("average execute time: {}", timeNum.get() / taskNum.get());
        } finally {
            super.terminated();
        }
    }

}
