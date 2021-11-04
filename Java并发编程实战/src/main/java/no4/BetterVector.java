package no4;

import java.util.Vector;

/**
 * @author Leesin Dong
 * @since 2021/11/4
 */
public class BetterVector<E> extends Vector<E> {
    public synchronized void putIfAbsent(E x) {
        try {
            boolean absent = !contains(x);
            if (absent) {
                add(x);
            }
        } catch (Exception e) {
            throw new RuntimeException("add error");
        }
    }
}
