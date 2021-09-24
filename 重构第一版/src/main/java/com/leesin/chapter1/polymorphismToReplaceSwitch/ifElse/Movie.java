package com.leesin.chapter1.polymorphismToReplaceSwitch.ifElse;

/**
 * @description:
 * @author: dongxueyuan
 * @date: Created in 2020/12/1 6:35 下午
 */
public class Movie {

    Price _price = new Price();

    int getFrequentRenterPoints(int daysRented) {
        return _price.getFrequentRenterPoints(daysRented);
    }
}
