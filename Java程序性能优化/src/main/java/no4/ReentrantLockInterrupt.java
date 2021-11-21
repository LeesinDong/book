package no4;

import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Leesin Dong
 * @since 2021/11/21
 */
public class ReentrantLockInterrupt {
    ReentrantLock lock = new ReentrantLock();
    public void interruptThread() {
        try {
            boolean b = lock.tryLock(1000, TimeUnit.SECONDS);
            if (!b) {
                return;
            }
            System.out.println(Thread.currentThread().getName() + "get lock");
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + "intterrupt");
            Thread.currentThread().interrupt();
            return;
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            System.out.println(Thread.currentThread().getName() + "unlock lock");
        }
    }

    @Test
    public void test() throws InterruptedException {
        new Thread(() -> {
            interruptThread();
        }, "1").start();
        Thread.sleep(1000);
        Thread thread = new Thread(() -> {
            interruptThread();
        }, "2");
        thread.start();
        thread.interrupt();
        Thread.sleep(10000);
    }
}
