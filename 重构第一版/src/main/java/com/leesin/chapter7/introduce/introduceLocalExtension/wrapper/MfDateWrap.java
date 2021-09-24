package com.leesin.chapter7.introduce.introduceLocalExtension.wrapper;

import java.util.Date;

/**
 * @description:
 * @author: dongxueyuan
 * @date: Created in 2020/12/2 10:14 上午
 */
public class MfDateWrap {
    private Date _original;

    /**
     * 构造函数变成委托
     **/
    public MfDateWrap(String dateString) {
        _original = new Date(dateString);
    }

    /**
     * TODO: 转型函数变成赋值
     **/
    public MfDateWrap(Date arg) {
        _original = arg;
    }

    ;

    public Date toDate() {
        return new Date();
    }

    /**
     * TODO: 为原来无法改变的类提供委托函数
     **/
    public int getYear() {
        return _original.getYear();
    }

    public boolean equals(MfDateWrap arg) {
        return (toDate().equals(arg.toDate()));
    }

    public int getMonth() {
        return _original.getMonth();
    }

    /**
     * TODO: 这里才是本质
     **/
    public int getDate() {
        return _original.getDate();
    }

    /**
     * TODO: 变成调用当前类的代理方法
     **/
    Date nextDay() {
        return new Date(getYear(), getMonth(), getDate() + 1);
    }

    public boolean after(Date arg) {
        return false;
    }

    /**
     * 原文：使用wrappers有一个特殊问题：如何处理「接受原始类之实体为参数」的函数？例如：public boolean after (Date arg)
     * 其实想说的是equals的问题：
     * <p>
     * 就是弄混了，不知道到底是 重写Object的equals还是Date的equals方法
     * subClass就不存在这个问题，因为直接overrideDate的，但是还是会弄混。
     * <p>
     * 避免的方法就是尽量少覆写原类的函数，而是添加新函数
     * <p>
     * 覆写的Object的equals，系统认为 a.equals(b) 一定 b.equals(a)
     * 但是这里的equals指的是wrapper本身的比较，而里面确实日期的
     **/
    public boolean equals(Date arg) {
        return _original.equals(arg);
    }

    /**
     * 重新命名一个
     **/
    public boolean equalsDate(Date arg) {
        return _original.equals(arg);
    }

    /**
     * 也可以传入wrapper
     **/
    public boolean equalsDate(MfDateWrap arg) {
        return _original.equals(arg);
    }
}
