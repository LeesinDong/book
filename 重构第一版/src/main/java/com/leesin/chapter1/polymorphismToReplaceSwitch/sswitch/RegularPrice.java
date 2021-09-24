package com.leesin.chapter1.polymorphismToReplaceSwitch.sswitch;

/**
 * @description:
 * @author: dongxueyuan
 * @date: Created in 2020/12/1 2:02 下午
 */
class RegularPrice extends Price {
    // int getPriceCode() {
    //     return Movie.REGULAR;
    // }

    @Override
    double getCharge(int daysRented) {
        double result = 2;
        if (daysRented > 2) {
            result += (daysRented - 2) * 1.5;
        }
        return result;
    }
}