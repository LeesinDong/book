package no83;

import no38.Apple;

/**
 * @author Leesin Dong
 * @since Created in 2021/10/3 2:09 下午
 */
public class Test {
    // not lay
    private final Apple apple = new Apple();

    private final static Apple apple1 = null;

    private volatile Apple apple2 = null;

    private volatile int apple3 = 0;

    private static  Apple initStatic4Lazy() {
        return Test.apple1;
    }

    private void initInstance4LazyTwo() {
        if (apple2 == null) {
            synchronized (this) {
                if (apple2 == null) {
                    apple2 = new Apple();
                }
            }
        }
    }

    private void initInstance4LazyOne() {
        synchronized (this) {
            if (apple2 == null) {
                apple2 = new Apple();
            }
        }
    }

    private void initInstance4LazyOneBasic() {
        synchronized (this) {
            if (apple3 == 0) {
                apple3 = 1;
            }
        }
    }
}
