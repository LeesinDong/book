package no7;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Leesin Dong
 * @since 2021/11/8
 */
public class ThreadExecutorFactory {
    private ThreadPoolExecutor threadPool = new ThreadPoolExecutor(1,
            1, 1, TimeUnit.MINUTES, new LinkedBlockingQueue<>(10),
            new ThreadFactory() {
                @Override
                public Thread newThread(Runnable r) {
                    return null;
                }
            });

}
