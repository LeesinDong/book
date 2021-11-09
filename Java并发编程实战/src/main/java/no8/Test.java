package no8;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

import static java.util.concurrent.Executors.newCachedThreadPool;

/**
 * @author Leesin Dong
 * @since 2021/11/9
 */
public class Test {
    @org.junit.Test
    public void test() {
        System.out.println(Runtime.getRuntime().availableProcessors());
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),
                Runtime.getRuntime().availableProcessors(),
                60000,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(),
                new ThreadFactoryBuilder().setNameFormat("Thread-%d").build());
        threadPoolExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
    }

    @org.junit.Test
    public void test1() throws ExecutionException, InterruptedException {
        Future<?> future = newCachedThreadPool().submit(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        future.get();
        System.out.println(1234);
    }
}
