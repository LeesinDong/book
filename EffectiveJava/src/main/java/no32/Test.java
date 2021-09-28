package no32;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Leesin Dong
 * @since Created in 2021/9/27 11:15 下午
 */
public class Test {
    public static void test(List<String>... lists) {
        List<Integer> integers = Arrays.asList(1, 2);
        Object[] lists1 = lists;
        lists1[0] = integers;
        String s = lists[0].get(0);
        System.out.println(s);
        // List.of(1);
    }

    public static void main(String[] args) {
        test(Collections.emptyList());
    }
}
