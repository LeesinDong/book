package com.leesin.chapter10.replaceConstructorWithFactoryMethod;

/**
 * @description:
 * @author: dongxueyuan
 * @date: Created in 2020/11/26 9:46 上午
 */
public class Employee {
    static final int ENGINEER = 0;
    static final int SALESMAN = 1;
    static final int MANAGER = 2;
    Employee eng = Employee.create(Employee.ENGINEER);

    // Employee(int type) {
    //     _type = type;
    // }
    private int _type;

    // TODO: 构造方法私有
    private Employee(int type) {
        _type = type;
    }

    // TODO:  创建工厂函数
    static Employee create(int type) {
        return new Employee(type);
    }

}


