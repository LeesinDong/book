package com.leesin.chapter1.polymorphismToReplaceSwitch.ifElse;

/**
 * @description:
 * @author: dongxueyuan
 * @date: Created in 2020/12/1 8:15 下午
 */
public class NewReleasePrice extends Price {

    /**
     * TODO: 2 else内容
     **/
    @Override
    int getFrequentRenterPoints(int daysRented) {
        return (daysRented > 1) ? 2 : 1;
    }
}
