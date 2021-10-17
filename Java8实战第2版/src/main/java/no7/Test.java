package no7;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author Leesin Dong
 * @since 2021/10/17
 */
public class Test {
    public void test() {

        Stream.of(1, 2, 3, 4, 5, 6)
                .parallel()
                .limit(2);

        Stream.of(1, 2, 3, 4, 5, 6)
                .unordered()
                .limit(2);

        Stream.of(1, 2, 3, 4, 5, 6)
                .parallel();
        Arrays.asList(1, 3).parallelStream().forEach(System.out::println);
        Arrays.asList(1, 3).parallelStream().parallel();

    }
}
