package com.leesin.chapter8.replaceSubclassWithFields;

/**
 * @description:
 * @author: dongxueyuan
 * @date: Created in 2020/12/2 1:40 下午
 */
public class Person {
    private final boolean _isMale;
    private final char _code;
    /**
     * new Male()改成
     **/
    Person kent = Person.createMale();

    // boolean isMale();
    // char getCode();

    // Person createMale() {
    //     return new Male();
    // }
    //
    // Person createFemale() {
    //     return new Female();
    // }

    // Person kent = new Male();
    protected Person(boolean isMale, char code) {
        _isMale = isMale;
        _code = code;
    }

    /**
     * TODO: 子类中只有两个常量函数，直接删了原来为了型别码建立的两个子类，用型别码【我认为型别码，用枚举保存，例子没有完善而已】
     **/
    static Person createMale() {
        return new Person(true, 'M');
    }
}
