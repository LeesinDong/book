package com.leesin.chapter7.introduce.introduceLocalExtension;

import java.util.Date;

/**
 * @description:
 * @author: dongxueyuan
 * @date: Created in 2020/12/2 10:04 上午
 */

/**
 * subClass
 **/
public class mfDate extends Date {
}

/**
 * 委托
 **/
class mdDate2 extends Date {
    private Date _original;
}
