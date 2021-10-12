package com.leesin.no3函数.no9.no1;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Leesin Dong
 * @since Created in 2021/10/11 8:28 上午
 */

@Slf4j
public class Test {
    public static void main(String[] args) {

    }

    private class Page {

    }

    public void testThrow() {
        try {
            deletePageThrow();
            deleteReferenceThrow();
            deleteKeyThrow();
            log.info("bbb");
        } catch (Exception e) {
            log.info("aaa");
        }
    }

    public void testThrowTry() {
        try {
            testThrowIn();
        } catch (Exception e) {
            log.info("aaa");
        }
    }

    public void testThrowIn() {
        deletePageThrow();
        deleteReferenceThrow();
        deleteKeyThrow();
        log.info("bbb");
    }

    public boolean deletePageThrow() {
        throw new RuntimeException();
    }

    public boolean deleteReferenceThrow() {
        throw new RuntimeException();
    }

    public boolean deleteKeyThrow() {
        throw new RuntimeException();
    }
}
