package no3;

import org.junit.Test;

import java.util.StringTokenizer;

/**
 * @author Leesin Dong
 * @since 2021/11/19
 */
public class StringTokenier {
    @Test
    public void test() {
        StringTokenizer s = new StringTokenizer("1,2,3", ",");
        StringBuilder sb = new StringBuilder();
        while (s.hasMoreTokens()) {
            sb.append(s.nextToken());
        }
        System.out.println(sb);
    }
}
