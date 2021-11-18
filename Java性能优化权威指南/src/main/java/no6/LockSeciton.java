package no6;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Leesin Dong
 * @since 2021/11/18
 */
public class LockSeciton {
    Map<String, Integer> map = new HashMap<>();

    public void Initial() {
        Map<Integer, Map<String, Integer>> result = new HashMap<>();
        int size = map.size();
        for (int i = 0; i < 10; i++) {
            HashMap<String, Integer> map = (HashMap<String, Integer>) Collections
                    .synchronizedMap(new HashMap<String, Integer>(size / 10));
            result.put(i, map);
        }
    }

    public void put() {

    }
}
