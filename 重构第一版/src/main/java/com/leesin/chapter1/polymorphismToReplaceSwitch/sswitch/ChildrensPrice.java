package com.leesin.chapter1.polymorphismToReplaceSwitch.sswitch;

/**
 * @description:
 * @author: dongxueyuan
 * @date: Created in 2020/12/1 2:02 下午
 */
class ChildrensPrice extends Price {
    // int getPriceCode() {
    //     return Movie.CHILDRENS;
    // }

    @Override
    double getCharge(int daysRented) {
        double result = 1.5;
        if (daysRented > 3) {
            result += (daysRented - 3) * 1.5;
        }
        return result;
    }
}