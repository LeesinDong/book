package no4;

import org.junit.Test;

/**
 * @author Leesin Dong
 * @since 2021/11/21
 */
public class VolatileTest {
    private  boolean stop = false;

    private void stop() {
        stop = true;
    }

    @Test
    public void test() throws InterruptedException {
        new Thread(() -> {
            int i = 0;
            while (!stop) {
                i++;
            }
            System.out.println(i);
            System.out.println("exit");
        }).start();

        Thread.sleep(1000);

        new Thread(() -> {
            stop();
        }).start();

        Thread.sleep(200000);
    }
}
