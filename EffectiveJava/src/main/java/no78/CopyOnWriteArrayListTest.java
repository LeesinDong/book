package no78;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Leesin Dong
 * @since Created in 2021/10/3 10:37 上午
 */
public class CopyOnWriteArrayListTest {

    private final List<Integer> list = new CopyOnWriteArrayList<>();

    public void add(Integer a) {
        list.add(a);
    }

    public void remove() {

    }
}
