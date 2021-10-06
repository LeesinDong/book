package no15;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Leesin Dong
 * @since Created in 2021/10/4 2:23 下午
 */
public class Test {
    private static final Integer[] ARR = {1, 2, 3};

    public static List<Integer> values = Collections.unmodifiableList(Arrays.asList(ARR));

    public static Integer[] getArr() {
        return ARR;
    }
}
