package no38;

import java.util.List;

/**
 * @author Leesin Dong
 * @since Created in 2021/9/29 10:59 上午
 */
public class Test {
    interface A{}

    enum B implements A {

    }

    enum C implements A {

    }

    public static void test(List<? super B> list) {

    }

    public static void main(String[] args) {
        Apple apple = new Apple();
        // B b = new B();
        // test(apple);
        // test(Arrays.asList(b));
    }
}
