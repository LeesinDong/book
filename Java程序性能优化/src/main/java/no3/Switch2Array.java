package no3;

import org.junit.Test;

/**
 * @author Leesin Dong
 * @since 2021/11/20
 */
public class Switch2Array {
    @Test
    public void test() {
        int[] sw = new int[]{1, 2, 4, 5};
        for (int i = 0; i < 6; i++) {
            System.out.println(arrayValue(sw, i));
        }
    }

    private int arrayValue(int[] sw, int i) {
        if (i < 4) {
            return sw[i];
        } else {
          return -1;
        }
    }
}
