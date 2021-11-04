package no4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Leesin Dong
 * @since 2021/11/4
 */
public class ListHelper<E> {
    public List<E> list = Collections.synchronizedList(new ArrayList<E>());
    private boolean absent;

    public void putIfAbsent(E x) {
        try {
            synchronized (this) {
                absent = !list.contains(x);
                if (absent) {
                    list.add(x);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
