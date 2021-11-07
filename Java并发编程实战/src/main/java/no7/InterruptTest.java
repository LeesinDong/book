package no7;

import java.util.concurrent.BlockingQueue;

/**
 * @author Leesin Dong
 * @since 2021/11/7
 */
public class InterruptTest {
    public static void main(String[] args) {

    }

    public static void test(BlockingQueue<String> queue) {
        boolean isInterrupted = false;
        try {
            while (true) {
                try {
                    queue.take();
                } catch (InterruptedException e) {
                    isInterrupted = true;
                }
            }
        } finally {
            if (isInterrupted) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
