package no3;

import org.junit.Test;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author Leesin Dong
 * @since 2021/11/19
 */
public class TreeMapTest {
    private final TreeMap<Integer, Integer> map =
            new TreeMap<>(Integer::compare);
    @Test
    public void test() {
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        SortedMap<Integer, Integer> integerIntegerSortedMap = map.headMap(1);
        // System.out.println(integerIntegerSortedMap);

        String s = "";
        System.out.println(s.length());
        if (((s = "a").indexOf("a") != -1) || s.length() == 1) {
            System.out.println(true);
        }
    }
}
