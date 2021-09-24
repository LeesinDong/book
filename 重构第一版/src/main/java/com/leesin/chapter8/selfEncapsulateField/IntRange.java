package com.leesin.chapter8.selfEncapsulateField;

/**
 * @description:
 * @author: dongxueyuan
 * @date: Created in 2020/12/2 1:05 下午
 */
public class IntRange {
    private int _low, _high;

    public IntRange(int low, int high) {

    }

    boolean includes(int arg) {
        return arg >= getLow() && arg <= getHigh();
    }

    void grow(int factor) {
        setHigh(getHigh() * factor);
    }

    int getLow() {
        return _low;
    }

    void setLow(int arg) {
        _low = arg;
    }

    int getHigh() {
        return _high;
    }

    void setHigh(int arg) {
        _high = arg;
    }
}
