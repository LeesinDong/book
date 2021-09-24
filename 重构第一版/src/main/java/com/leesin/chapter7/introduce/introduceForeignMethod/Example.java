package com.leesin.chapter7.introduce.introduceForeignMethod;

import java.util.Date;

/**
 * @description:
 * @author: dongxueyuan
 * @date: Created in 2020/12/2 9:52 上午
 */
public class Example {

    private Date previousEnd;
    Date newStart = nextDay(previousEnd);
    private Date reviousEnd;
    Date newStartOriginal = new Date(previousEnd.getYear(), reviousEnd.getMonth(), previousEnd.getDate() + 1);

    private static Date nextDay(Date arg) {
        // foreign method, should be on date
        // TODO: 无法修改Date源码，就调用Date类中的方法，这个方法就成了Date的外加函数，从而实现额外的功能
        //  然后可以通过静态代理调用这个外加函数
        //  总结：就是通过传入的参数，然后静态代理
        return new Date(arg.getYear(), arg.getMonth(), arg.getDate() + 1);
    }
}
