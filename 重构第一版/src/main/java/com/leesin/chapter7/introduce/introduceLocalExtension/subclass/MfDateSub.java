package com.leesin.chapter7.introduce.introduceLocalExtension.subclass;

import java.util.Date;

/**
 * @description:
 * @author: dongxueyuan
 * @date: Created in 2020/12/2 10:06 上午
 */

/**
 * TODO: 把introduceForeignMethod的升级，多了构造函数，他就相当于Date了 1 Date的子类 2 Date的扩展方法
 **/
class MfDateSub extends Date {

    /**
     * 构造函数
     **/
    public MfDateSub(String dateString) {
        super(dateString);
    }

    ;

    /**
     * TODO: 转型函数，参数是原类【无法修改的类】对象
     **/
    public MfDateSub(Date arg) {
        super(arg.getTime());
    }

    /**
     * TODO: 变成调用当前类的父类，即也是自己的方法getYear()等
     **/
    Date nextDay() {
        /**
         * TODO: getYear()才是本质
         **/
        return new Date(getYear(), getMonth(), getDate() + 1);
    }

    /**
     * 可以覆写父类的方法，然后调用被覆写的方法
     **/
    @Override
    public boolean equals(Object arg) {
        return false;
    }

}
