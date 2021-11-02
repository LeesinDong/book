package no2;

import java.math.BigInteger;

/**
 * @author Leesin Dong
 * @since 2021/11/1
 */
public class CachedFactorizer {
    private BigInteger lastNumber;
    private BigInteger[] lastFactors;
    private long hits;
    private long cacheHits;

    public synchronized long getHits() {
        return hits;
    }

    public synchronized double getCacheHitRatio() {
        return cacheHits / hits;
    }

    public void service(Test req, Test resp) {
        BigInteger i = otherOperation(req);
        BigInteger[] factors = null;

        synchronized (this) {
            ++hits;
            if (i.equals(lastNumber)) {
                ++cacheHits;
                factors = lastFactors.clone();
            }
        }

        if (factors == null) {
            factors = otherOperationSecond(req);
            synchronized (this) {
                lastNumber = i;
                lastFactors = factors.clone();
            }
        }

        otherOperation(resp, lastFactors);
    }

    public BigInteger otherOperation(Test test) {
        return BigInteger.valueOf(1);
    }

    public BigInteger otherOperation(Test test, BigInteger[] lastFactors) {
        return BigInteger.valueOf(1);
    }

    public BigInteger[] otherOperationSecond(Test test) {
        return new BigInteger[]{BigInteger.valueOf(1)};
    }

    private static class Test {

    }
}
