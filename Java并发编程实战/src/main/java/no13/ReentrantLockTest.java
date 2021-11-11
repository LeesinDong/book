package no13;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Leesin Dong
 * @since 2021/11/11
 */
public class ReentrantLockTest {
    ReentrantLock reentrantLock = new ReentrantLock();
    ReentrantLock lock1 = new ReentrantLock();
    ReentrantLock lock2 = new ReentrantLock();
    ReentrantLock timeLock = new ReentrantLock();
    private final Long endTime = 1L;

    public void test() {
        reentrantLock.lock();
        try {
            // xxx
        } finally {
            reentrantLock.unlock();
        }
    }

    // 可轮询
    public void resolveDeadLock() throws InterruptedException {
        while (true) {
            if (lock1.tryLock()) {
                try {
                    if (lock2.tryLock()) {
                        try {
                            // xxx
                        } finally {
                            lock2.unlock();
                        }
                    }
                } finally {
                    lock1.unlock();
                }
            }
            if (System.nanoTime() < endTime) {
                Thread.sleep(ThreadLocalRandom.current().nextInt());
            }
        }
    }

    public void timingFailed() throws InterruptedException {
        try {
            timeLock.tryLock(1, TimeUnit.MICROSECONDS);
            try {
                // xxx
            } finally {
                timeLock.unlock();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void interrupted() {
        try {
            lock1.lockInterruptibly();
            try {
                // xx
            } finally {
                lock1.unlock();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
