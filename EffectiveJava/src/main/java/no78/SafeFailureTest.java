package no78;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Leesin Dong
 * @since Created in 2021/10/3 10:04 上午
 */
public class SafeFailureTest {

    private static AtomicInteger i = new AtomicInteger();

    private  static int add() {
        return i.getAndIncrement();
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CountDownLatch countDownLatch = new CountDownLatch(1000);

            for (int i = 0; i < 1000; i++) {
            executorService.execute(() -> {
                add();
                countDownLatch.countDown();
            });
        }
            countDownLatch.await();
            System.out.println(i);
    }
}
