package no36;

import java.util.EnumSet;
import java.util.Set;

/**
 * @author Leesin Dong
 * @since Created in 2021/9/29 9:41 上午
 */
public enum Test {
    bold, italic;


    private static class Test1 {
        public static void applyStyle(Set<Test> set) {

        }

        public static void main(String[] args) {
            Test1.applyStyle(EnumSet.of(Test.bold));
        }
    }
}
