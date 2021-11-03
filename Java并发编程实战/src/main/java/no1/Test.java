package no1;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Leesin Dong
 * @since 2021/11/3
 */
public class Test {
    private final AtomicLong count = new AtomicLong(0);

    public long getCount() {
        return count.get();
    }

    public void add() {
        count.incrementAndGet();
    }

    @org.junit.Test
    public void test() {
        add();
        add();
        add();

        System.out.println(getCount());
    }
}
