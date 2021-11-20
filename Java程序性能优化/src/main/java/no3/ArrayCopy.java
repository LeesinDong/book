package no3;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Leesin Dong
 * @since 2021/11/20
 */
public class ArrayCopy {
    private int[] arr = new int[]{1, 2, 2, 3};
    @Test
    public void test() {
        System.arraycopy(arr, 0, arr, 1, 2 );
        Arrays.stream(arr).forEach(System.out::println);
    }
}
