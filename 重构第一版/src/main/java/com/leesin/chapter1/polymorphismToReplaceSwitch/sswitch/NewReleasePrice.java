package com.leesin.chapter1.polymorphismToReplaceSwitch.sswitch;

/**
 * @description:
 * @author: dongxueyuan
 * @date: Created in 2020/12/1 2:02 下午
 */
class NewReleasePrice extends Price {
    // int getPriceCode() {
    //     return Movie.NEW_RELEASE;
    // }

    @Override
    double getCharge(int daysRented) {
        return daysRented * 3;
    }

    // int getFrequentRenterPoints(int daysRented) {
    //     return (daysRented > 1) ? 2 : 1;
    // }
}