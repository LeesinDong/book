package no8;

import com.google.common.base.Joiner;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Leesin Dong
 * @since 2021/11/9
 */
@Slf4j
public class MyThreadFacotry implements ThreadFactory {
    private final String poolName;

    public MyThreadFacotry(String poolName) {
        this.poolName = poolName;
    }

    @Override
    public Thread newThread(Runnable r) {
        return new MyAppThread(r, poolName);
    }

    private static class MyAppThread extends Thread{

        private static final AtomicInteger CREATED = new AtomicInteger();
        private static final AtomicInteger ALIVE = new AtomicInteger();

        public MyAppThread(Runnable r, String poolName) {
            super(r, Joiner.on("-").join(new String[] {poolName, CREATED.getAndIncrement() + ""}));
            setUncaughtExceptionHandler((t, e) -> log.info(t.getName(), e));
        }

        @Override
        public void run() {
            try {
                log.info("begin thread.");
                ALIVE.incrementAndGet();
                super.run();
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                ALIVE.decrementAndGet();
                log.info("end thread.");
            }
        }

        public static int getAlive() {
            return ALIVE.get();
        }

        public static int getCreated() {
            return CREATED.get();
        }
    }
}
