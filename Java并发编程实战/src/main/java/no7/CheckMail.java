package no7;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author Leesin Dong
 * @since 2021/11/8
 */
public class CheckMail {
    volatile boolean hasNewMail = false;
    private AtomicBoolean hasNewMailAtomic = new AtomicBoolean(false);
   ExecutorService executorService =  Executors.newFixedThreadPool(10);
    private int[] hosts = new int[]{1, 2, 3};

    @Test
    public void test() throws InterruptedException {
        try {
            for (int host : hosts) {
                executorService.execute(() -> {
                    if (checkMail()) {
                        hasNewMail = true;
                    }
                });
            }
        } finally {
            executorService.shutdown();
            executorService.awaitTermination(100, TimeUnit.SECONDS);
        }
        System.out.println(hasNewMail);
    }

    public boolean checkMail() {
        return true;
    }
}
