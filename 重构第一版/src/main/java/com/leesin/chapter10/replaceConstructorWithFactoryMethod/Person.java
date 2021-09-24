package com.leesin.chapter10.replaceConstructorWithFactoryMethod;

/**
 * @description: 隐藏subclass
 * @author: dongxueyuan
 * @date: Created in 2020/11/26 10:05 上午
 */
public class Person {
    // Person kent = new Male();
    // TODO: 构造函数换成 通过固定工厂方法创建子类
    Person kent = Person.createMale();

    static Person createMale() {
        return new Male();
    }

    static Person createFemale() {
        return new Female();
    }

    private static class Male extends Person {
    }

    private static class Female extends Person {
    }
}
