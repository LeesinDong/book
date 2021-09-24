package com.leesin.chapter1.polymorphismToReplaceSwitch.sswitch;

/**
 * @description:
 * @author: dongxueyuan
 * @date: Created in 2020/12/1 2:02 下午
 */
abstract public class Price {

    abstract double getCharge(int daysRented);

    // abstract double getCharge();

    // abstract int getPriceCode();

    // double getCharge(int daysRented) {
    //     double result = 0;
    //     switch (getPriceCode()) {
    //         case Movie.REGULAR:
    //             result += 2;
    //             if (daysRented > 2) {
    //                 result += (daysRented - 2) * 1.5;
    //             }
    //             break;
    //         case Movie.NEW_RELEASE:
    //             result += daysRented * 3;
    //             break;
    //         case Movie.CHILDRENS:
    //             result += 1.5;
    //             if (daysRented > 3) {
    //                 result += (daysRented - 3) * 1.5;
    //             }
    //             break;
    //     }
    //     return result;
    //
    // }

    int getFrequentRenterPoints(int daysRented) {
        return 1;
    }

}
