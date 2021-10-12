package com.leesin.no7错误处理.no2;

/**
 * @author Leesin Dong
 * @since 2021/10/11
 */
public class Test {
    public static void main(String[] args) {

    }

    @org.junit.Test
    public void test() {
        // List<Object> objects = Collections.emptyList();
        // for (Object object : objects) {
        //     System.out.println(1);
        // }
        testThrow(null);
    }

    public void testThrow(Test t) {
        // throw new RuntimeException("12345");
    }
}
