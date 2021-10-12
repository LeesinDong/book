package com.leesin.no3函数.no9;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Leesin Dong
 * @since Created in 2021/10/11 8:11 上午
 */
@Slf4j
public class Test {
    public static void main(String[] args) {

    }

    public void test() {
        if (deletePage()) {
            if (deleteReference()) {
                if (deleteKey()) {
                    log.info("aaa");
                }
            }
        } else {
            log.info("bbb");
        }
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

    public boolean deletePage() {
        return false;
    }

    public boolean deleteReference() {
        return true;
    }

    public boolean deleteKey() {
        return false;
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
