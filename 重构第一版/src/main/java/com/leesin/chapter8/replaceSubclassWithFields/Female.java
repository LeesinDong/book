package com.leesin.chapter8.replaceSubclassWithFields;

/**
 * @description:
 * @author: dongxueyuan
 * @date: Created in 2020/12/2 1:40 下午
 */
public class Female extends Person {

    Female() {
        super(false, 'F');
    }

    /**
     * 它们以不同的方式实现了 Person 所声明的抽象函数getCode() ，
     * 返回不同的硬编码常量（所以getCode() 是个常量函数[Beck]）。我应该将这两个怠惰subclasses 的去掉。
     **/
    boolean isMale() {
        return false;
    }

    char getCode() {
        return 'F';
    }
}
