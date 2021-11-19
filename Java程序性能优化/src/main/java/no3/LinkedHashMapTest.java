package no3;

import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * @author Leesin Dong
 * @since 2021/11/19
 */
public class LinkedHashMapTest {
    private LinkedHashMap<Integer, Integer> map =
            new LinkedHashMap<Integer, Integer>(16, 0.75f, true);
    // private Map<Integer, Integer> map = new HashMap<>();

    @Test
    public void test() {
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        map.put(4, 4);
        map.get(2);
        for (Iterator<Integer> i = map.keySet().iterator(); i.hasNext(); ) {
            Integer next = i.next();
            System.out.println(next);
        }
    }
}
