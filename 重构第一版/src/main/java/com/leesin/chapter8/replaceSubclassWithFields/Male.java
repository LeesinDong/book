package com.leesin.chapter8.replaceSubclassWithFields;

/**
 * @description:
 * @author: dongxueyuan
 * @date: Created in 2020/12/2 1:40 下午
 */
public class Male extends Person {

    Male() {
        super(true, 'M');
    }

    boolean isMale() {
        return true;
    }

    char getCode() {
        return 'M';
    }
}
