package no15;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Leesin Dong
 * @since 2021/11/13
 */
public class CompoundConditions {
    // 复合操作不加锁情况
    ConcurrentHashMap chm = new ConcurrentHashMap();

    private void entrust() {
        if (chm.get(1) != null) {
            chm.putIfAbsent(1, 2);
        }
    }

    private void orSecurity() {
        if (chm.get(1) != null && chm.get(2) != null) {
            chm.putIfAbsent(1, 2);
        }
    }

    private static class IntPair {
        private final int left;
        private final int right;


        public IntPair(int left, int right) {
            this.left = left;
            this.right = right;
        }

        public int getLeft() {
            return left;
        }

        public int getRight() {
            return right;
        }
    }

    private volatile IntPair volatilePair = new IntPair(1, 2);
    private void volatileSecurity() {
        if (volatilePair.getLeft() != 2) {
            volatilePair = new IntPair(2, 3);
        }
    }

    private final AtomicReference<IntPair> atomicPair = new AtomicReference<IntPair>(new IntPair(1, 2));
    private void atomicSecurity() {
        while (true) {
            if (atomicPair.compareAndSet(atomicPair.get(), new IntPair(2, 3))) {
                return;
            }
        }

    }
}
