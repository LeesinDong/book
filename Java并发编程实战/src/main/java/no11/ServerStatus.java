package no11;

import java.util.Set;

/**
 * @author Leesin Dong
 * @since 2021/11/10
 */
public class ServerStatus {
    // 锁分解
    private Set<String> one;
    private Set<String> two;

    public void addOne() {
        synchronized (one) {
            one.add("one");
        }
    }

    public void addTwo() {
        synchronized (two) {
            two.add("two");
        }
    }
}
