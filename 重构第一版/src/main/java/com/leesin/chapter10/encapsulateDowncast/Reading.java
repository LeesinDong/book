package com.leesin.chapter10.encapsulateDowncast;

/**
 * @description:
 * @author: dongxueyuan
 * @date: Created in 2020/11/26 1:26 下午
 */
public class Reading {
    Readings readings = new Readings();

    Object lastReadingOriginal() {
        return readings.lastElement();
    }

    // 普通的转型操作
    Reading lastReading() {
        return (Reading) readings.lastElement();
    }
}


