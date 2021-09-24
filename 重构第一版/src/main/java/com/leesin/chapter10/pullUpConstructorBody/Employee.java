package com.leesin.chapter10.pullUpConstructorBody;

/**
 * @description:
 * @author: dongxueyuan
 * @date: Created in 2020/11/30 1:46 下午
 */
public class Employee {
    protected String _name;
    protected String _id;

    protected Employee(String name, String id) {
        _name = name;
        _id = id;
    }

    boolean isPriviliged() {
        return false;
    }

    void assignCar() {
    }
}
