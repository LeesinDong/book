package no7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Leesin Dong
 * @since 2021/11/8
 */
public class ShutDown {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        // executorService.shutdown();
        boolean b = executorService.awaitTermination(1, TimeUnit.SECONDS);
        System.out.println(b);
        boolean terminated = executorService.isTerminated();
        System.out.println(terminated);
    }
}
