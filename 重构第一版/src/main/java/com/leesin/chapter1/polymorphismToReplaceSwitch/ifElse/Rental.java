package com.leesin.chapter1.polymorphismToReplaceSwitch.ifElse;

import com.leesin.chapter1.polymorphismToReplaceSwitch.sswitch.Movie;

/**
 * @description:
 * @author: dongxueyuan
 * @date: Created in 2020/12/1 6:35 下午
 */
public class Rental {
    /**
     * 原来的if else
     **/
    int getFrequentRenterPoints(int daysRented) {
        if ((getPriceCode() == Movie.NEW_RELEASE) && daysRented > 1) {
            return 2;
        } else {
            return 1;
        }
    }

    private int getPriceCode() {
        return 0;
    }
}
