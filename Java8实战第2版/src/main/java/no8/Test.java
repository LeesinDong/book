package no8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Leesin Dong
 * @since 2021/10/17
 */
public class Test {

    @org.junit.Test
    public void test() {
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);

        System.out.println(integers.removeIf(i -> i > 2));

        integers.replaceAll(i -> i + 2);
        System.out.println(integers);

        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 2);
        map.put(2, 3);
        map.forEach((k, v) -> System.out.println(k + v));
        System.out.println(map);

        System.out.println("=============");
        // map.compute(10, (k, v) -> v + 1);
        System.out.println(map);

        map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEachOrdered(System.out::println);

        System.out.println(map.getOrDefault(1, 0));
        System.out.println(map.getOrDefault(10, 0));
        System.out.println(map);

        Integer integer = map.computeIfAbsent(3, i -> i + 1);
        System.out.println(integer);
        System.out.println(map);

        Map<Integer, List<String>> map1 =new HashMap<>();
        map1.computeIfAbsent(1, i -> new ArrayList<>()).add("sss");
        System.out.println(map1);

        map.computeIfPresent(1, (k, v) -> v + 1);
        System.out.println(map);

        // map.computeIfPresent(1, (k, v) -> null);
        // System.out.println(map);

        map.remove(1, 3);
        System.out.println(map);

        map.replaceAll((k, v) -> k + 1);
        System.out.println(map);

        map.replaceAll((k, v) -> v + 1);
        System.out.println(map);

        Map<Integer, Integer> map2 = new HashMap<>();
        map2.put(2, 3);
        // map2.putAll(map);
        // System.out.println(map2);

        map.forEach((k, v) -> map2.merge(k, v, (v1, v2) -> v1 + v2));
        System.out.println(map2);


        Map<String, Integer> movie = new HashMap<>();
        movie.merge("肖申克的救赎", 1, (k, v) -> k + 1);
        // movie.merge("肖申克的救赎", 1, (k, v) -> v + 1);
        System.out.println(movie);

        ConcurrentHashMap<Integer, Integer> chm = new ConcurrentHashMap<>();
        chm.put(1, 2);
        chm.put(2, 3);
        Integer integer1 = chm.reduceKeys(1, Integer::sum);
        System.out.println(chm);
        System.out.println(integer1);

        System.out.println(chm.mappingCount());

        System.out.println(chm.keySet());



    }
}
