package no3.composite;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.IntPredicate;

/**
 * @author Leesin Dong
 * @since 2021/10/15
 */
public class Test {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3);
        integers.sort(Comparator.comparing(Integer::intValue)
                .reversed()
                .thenComparing(Integer::intValue));

        IntPredicate intPredicate = ((IntPredicate) (int i) -> i > 1).negate();
        IntPredicate intPredicate1 = ((IntPredicate) (int i) -> i > 1)
                .and((i) -> i > 1)
                .or((i) -> i < 2);
    }
}
