package no7;

import org.junit.Test;

/**
 * @author Leesin Dong
 * @since 2021/11/8
 */
public class missThread {
    @Test
    public void test() throws InterruptedException {
        new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            throw new RuntimeException();
        }).start();

        Thread.sleep(5000);
    }

    @Test
    public void test1() {
        boolean interrupted = Thread.interrupted();
        System.out.println(interrupted);
    }

    @Test
    public void joinTest() throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("1234");
        });
        thread.start();
        thread.join(500);
        System.out.println("结束");
    }
}
