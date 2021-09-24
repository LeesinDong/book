package com.leesin.chapter10.hideMethod;

/**
 * @description:
 * @author: dongxueyuan
 * @date: Created in 2020/11/25 1:45 下午
 */

class Account {
    private String _id;

    Account(String id) {
        setId(id);
    }

    void setId(String arg) {
        _id = arg;
    }
}

class Account1 {
    private final String _id;

    Account1(String id) {
        _id = id;
    }
}