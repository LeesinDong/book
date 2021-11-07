package no7;

import org.junit.Test;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Leesin Dong
 * @since 2021/11/7
 */
public class Primegenerator {
    private volatile boolean notCancel = true;

    @Test
    public void test() throws InterruptedException {
        new Thread(() -> {
            while (notCancel) {
                System.out.println("12345");
            }
        }).start();

        Thread.sleep(3000);
        cancel();
    }

    @Test
    public void testInterrupt() throws InterruptedException {
        LinkedBlockingQueue<Object> queue = new LinkedBlockingQueue<>(10);
        new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    // 只能放10个，阻塞等待
                    queue.put(1234);
                    System.out.println(12345);
                } catch (InterruptedException e) {
                    // 中断
                    e.printStackTrace();
                }
            }
        }).start();

        Thread.sleep(3000);
        cancelInterrupt();
    }

    @Test
    public void test3(){
        boolean interrupted = false;
        try {
            while(true) {
                try {
                    throw new RuntimeException();
                } catch (RuntimeException e) {
                    System.out.println("catch");
                    Thread.currentThread().interrupt();
                    // interrupted = true;
                }
            }
        }finally {
            System.out.println("外层 finally");
            if (interrupted) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private void cancelInterrupt() {
        Thread.currentThread().interrupt();
    }
    private void cancel() {
        notCancel = false;
    }
}
