package no3;

import java.util.Arrays;

/**
 * @author Leesin Dong
 * @since 2021/11/2
 */
public class OneValueCache {
    private final Integer lastNumber;
    private final Integer[] lastFactors;

    public OneValueCache(Integer lastNumber, Integer[] lastFactors) {
        this.lastNumber = lastNumber;
        this.lastFactors = Arrays.copyOf(lastFactors, lastFactors.length);
    }

    public Integer[] getLastFactors() {
        return Arrays.copyOf(lastFactors, lastFactors.length);
    }

    private static class VolatileCacheFacotorizer {
        // 可见性
        private volatile OneValueCache cache = new OneValueCache(null, null);

        public void servlet() {
            // 两次更新操作 原子性
            new OneValueCache(1, new Integer[]{1});
        }
    }
}
