package no3;

import org.junit.Test;

/**
 * @author Leesin Dong
 * @since 2021/11/19
 */
public class SubStringTest {
    @Test
    public void test() {
        String str = new String(new char[100000]);
        String s = new String(str.substring(1, 2));
        System.out.println(str.toString());
    }
}
