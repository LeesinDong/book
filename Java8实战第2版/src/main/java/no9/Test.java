package no9;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Leesin Dong
 * @since 2021/10/18
 */
public class Test {

    @Builder
    @Data
    @AllArgsConstructor
    private static class Apple {
        private int length;
        private String name;
    }

    public static void main(String[] args) {
        Stream.of(new Apple(1, ""), new Apple(2, ""))
                .collect(Collectors.summingInt(Apple::getLength));

        List<Integer> collect = Stream.of(1, 2, 3)
                .map(Test::getInteger)
                .collect(Collectors.toList());
    }

    private static Integer getInteger(Integer i) {
        return i = i + 1;
    }
}
