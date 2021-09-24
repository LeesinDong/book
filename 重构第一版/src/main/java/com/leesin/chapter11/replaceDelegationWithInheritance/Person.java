package com.leesin.chapter11.replaceDelegationWithInheritance;

/**
 * @description:
 * @author: dongxueyuan
 * @date: Created in 2020/12/1 9:46 上午
 */
public class Person {
    String _name;

    public String getName() {
        return _name;
    }

    public void setName(String arg) {
        _name = arg;
    }

    public String getLastName() {
        return _name.substring(_name.lastIndexOf(' ') + 1);
    }
}
