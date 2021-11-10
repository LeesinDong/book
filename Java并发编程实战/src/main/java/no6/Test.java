package no6;

import lombok.SneakyThrows;

import java.util.concurrent.*;

/**
 * @author Leesin Dong
 * @since 2021/11/6
 */
public class Test {
    private static ExecutorService executor = Executors.newFixedThreadPool(1);

    public static void main(String[] args) throws InterruptedException {
        executor.execute(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                for (int i = 0; i < 2; i++) {
                    System.out.println("1234");
                    Thread.sleep(1000);
                }
            }
        });

        boolean b = executor.awaitTermination(100, TimeUnit.MILLISECONDS);
        System.out.println(b);

        // Thread.sleep(5000);
        // boolean terminated = executor.isTerminated();
        // System.out.println(terminated);

        // Future<Object> submit = executor.submit(new Callable<Object>() {
        //
        //     @Override
        //     public Object call() throws Exception {
        //         return null;
        //     }
        // });
        //
        // Future<?> submit1 = executor.submit(new Runnable() {
        //     @Override
        //     public void run() {
        //
        //     }
        // });
        //
        // Future<?> submit2 = executor.submit(new FutureTask(new Callable() {
        //     @Override
        //     public Object call() throws Exception {
        //         return null;
        //     }
        // }));

        // Thread.sleep(2000);
        // executor.shutdownNow();

        // Thread.sleep(10000);
    }
}
