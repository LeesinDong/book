package com.leesin.no9整洁的测试.no3;

/**
 * @author Leesin Dong
 * @since 2021/10/12
 */
public class Test {

    @org.junit.Test
    public void testMerge() {
        // assertFalse(Boolean.FALSE);
        // assertTrue(Boolean.TRUE);

        // assertEquals("01", testAssert());
    }

    public String testAssert() {
        StringBuilder sb = new StringBuilder();
        sb.append(Boolean.FALSE ? 1 : 0);
        sb.append(Boolean.TRUE ? 1 : 0);
        return sb.toString();
    }

    public void testGivenWhenThen() {
        // givenResource();
        // whenComplete();
        // thenShouleContains();
    }

}
