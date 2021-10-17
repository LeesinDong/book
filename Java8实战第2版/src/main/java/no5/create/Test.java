package no5.create;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @author Leesin Dong
 * @since 2021/10/16
 */
public class Test {
    public static void main(String[] args) {
        List<String> i1 = Stream.of(1, 2)
                .flatMap(i -> Stream.ofNullable(System.getProperty("i")))
                .collect(toList());
    }


}
