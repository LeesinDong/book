package no10;

import org.junit.Test;

/**
 * @author Leesin Dong
 * @since 2021/11/10
 */
public class DeadLockDumpTest {
    private final Object left = new Object();
    private final Object right = new Object();

    private void fun1() {
        synchronized (left) {
            synchronized (right) {
                System.out.println(1);
            }
        }
    }

    private void fun2() {
        synchronized (right) {
            synchronized (left) {
                System.out.println(2);
            }
        }
    }

    @Test
    public void test() throws InterruptedException {
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int i1 = 0; i1 < 1000; i1++) {
                    fun1();
                }
            }).start();

            new Thread(() -> {
                for (int i1 = 0; i1 < 1000; i1++) {
                    fun2();
                }
            }).start();
        }

        Thread.sleep(100000);
    }
}
