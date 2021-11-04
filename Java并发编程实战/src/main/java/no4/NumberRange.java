package no4;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Leesin Dong
 * @since 2021/11/4
 */
public class NumberRange {
    private final AtomicInteger lower = new AtomicInteger(0);
    private final AtomicInteger upper = new AtomicInteger(0);

    public synchronized void setLower(int i) {
        if (i > upper.get()) {
            return;
        }

        lower.set(i);
    }

    public synchronized void setUpper(int i) {
        if (i < lower.get()) {
            return;
        }

        upper.set(i);
    }
}
