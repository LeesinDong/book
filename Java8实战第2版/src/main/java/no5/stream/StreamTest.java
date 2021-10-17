package no5.stream;

import java.util.Arrays;
import java.util.List;

/**
 * @author Leesin Dong
 * @since 2021/10/16
 */
public class StreamTest {
    public static void main(String[] args) {
        // List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        // List<Integer> collect = integers.stream().limit(2).collect(toList());
        // System.out.println(collect);
        //
        // Set<Integer> collect1 = integers.stream().takeWhile(i -> i > 0).collect(Collectors.toSet());
        // System.out.println(collect1);

        // Set<Integer> collect2 = integers.stream().dropWhile(i -> i > 1).collect(Collectors.toSet());
        // System.out.println(collect2);

        List<Integer> integers1 = Arrays.asList(1, 2, 3);
        List<Integer> integers2 = Arrays.asList(3, 4);
        integers1.stream()
                .flatMap(i -> integers2.stream()
                        .map(j -> Arrays.asList(i, j))
                        .filter(m -> (m.get(0) + m.get(1)) % 3 == 0))
                .forEach(System.out::println);

        // integers1.stream()
        //         .flatMap(i -> integers2.stream()
        //                 .filter( j -> i + j ))
        //                 .map(j -> Arrays.asList(i, j))
        //         .forEach(System.out::println);

        Arrays.asList(1, 2, 3).stream().map(i -> 1).reduce(Integer::sum).ifPresent(System.out::println);
        System.out.println(Arrays.asList(1, 2, 3).stream().count());
    }
}
