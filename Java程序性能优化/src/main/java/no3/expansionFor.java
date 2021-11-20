package no3;

import org.junit.Test;

/**
 * @author Leesin Dong
 * @since 2021/11/20
 */
public class expansionFor {
    @Test
    public void test() {
        int result = 0;
        for (int i = 0; i < 100000; i = i + 5) {
            result += i;
            result += i + 1;
            result += i + 2;
            result += i + 3;
            result += i + 4;
        }
        System.out.println(result);
    }

    @Test
    public void test1() {
        int result = 0;
        for (int i = 0; i < 100000; i++) {
            result += i;
        }
        System.out.println(result);
    }

    @Test
    public void test2() {
        int result = 0;
        for (int i = 0; i < 10; i = i + 3) {
            result += i;
            result += i + 1;
            result += i + 2;
        }
        System.out.println(result);
    }

    @Test
    public void test3() {
        int result = 0;
        for (int i = 0; i < 10; i++) {
            result += i;
        }
        System.out.println(result);
    }
}
