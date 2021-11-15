package no15;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Leesin Dong
 * @since 2021/11/13
 */
public class LockTest {
    private static class LockReentrantTest {
        private int i;
        private ReentrantLock lock = new ReentrantLock(false);

        private int nextInt() {
            lock.lock();
            try {
                return i++;
            }finally {
                lock.unlock();
            }
        }
    }

    private static class AtomicLockTest {
        private AtomicInteger i;

        private int nextInt() {
            while (true) {
                if (i.compareAndSet(i.get(), 2)) {
                    return i.get();
                }
            }
        }

        private int nextIntDoWhile() {
            int v;
            do {
                v = i.get();
            } while (v != i.compareAndExchange(v, v + 1));
            return v + 1;
        }
    }

}
