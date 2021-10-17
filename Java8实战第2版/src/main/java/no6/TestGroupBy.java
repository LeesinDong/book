package no6;

import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Leesin Dong
 * @since 2021/10/16
 */
public class TestGroupBy {

    @Test
    public void test() {
        Map<String, List<Integer>> collect = Stream.of(1, 2, 3, 4, 5, 6, 7)
                .collect(Collectors.groupingBy((i) -> {
                    if ((i % 2) == 0) {
                        return "偶数";
                    } else {
                        return "奇数";
                    }
                }));
        collect.entrySet().forEach(System.out::println);

    }
}
