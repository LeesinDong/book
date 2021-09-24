package com.leesin.chapter10.replaceParameterwithMethod;

import com.sun.xml.internal.bind.v2.TODO;

/**
 * @description:
 * @author: dongxueyuan
 * @date: Created in 2020/11/25 12:18 上午
 */
public class Example {
    private static  int _quantity = 1;
    private static int _itemPrice = 1;
    public double getPrice_original() {
        int basePrice = _quantity * _itemPrice;
        int discountLevel;
        if (_quantity > 100) {
            discountLevel = 2;
        } else {
            discountLevel = 1;
        }
        //  discountLevel这个变量，把他的操作封装到函数中
        double finalPrice = discountedPrice (basePrice, discountLevel);
        return finalPrice;
    }

    private double discountedPrice_original (int basePrice, int discountLevel) {
        if (discountLevel == 2) {
            return basePrice * 0.1;
        } else {
            return basePrice * 0.05;
        }
    }

    public double getPrice() {
        int basePrice = _quantity * _itemPrice;
        // TODO: 2020/11/25  discountLevel这个变量 操作封装起来
        int discountLevel = getDiscountLevel();
        double finalPrice = discountedPrice (basePrice, discountLevel);
        return finalPrice;
    }
    private int getDiscountLevel() {
        if (_quantity > 100) {
            return 2;
        } else {
            return 1;
        }
    }

    private double discountedPrice (int basePrice, int discountLevel) {
        // TODO: 2020/11/25  discountLevel变量被用的地方换成函数
        if (getDiscountLevel() == 2) {
            return basePrice * 0.1;
        } else {
            return basePrice * 0.05;
        }
    }

    private double discountedPrice (int basePrice) {
        if (getDiscountLevel() == 2) {
            return basePrice * 0.1;
        } else {
            return basePrice * 0.05;
        }
    }

    public double getPrice_1() {
        int basePrice = _quantity * _itemPrice;
        int discountLevel = getDiscountLevel();
        // TODO: 2020/11/25 去掉 discountLevel 参数
        double finalPrice = discountedPrice (basePrice);
        return finalPrice;
    }

    public double getPrice_2() {
        int basePrice = _quantity * _itemPrice;
        // TODO: 2020/11/25 去掉discountLevel 参数变量
        double finalPrice = discountedPrice (basePrice);
        return finalPrice;
    }

    //  同样方式 去掉basePrice半数
    public double getPrice_3() {
        return discountedPrice ();
    }

    private double discountedPrice () {
        if (getDiscountLevel() == 2) {
            return getBasePrice() * 0.1;
        } else {
            return getBasePrice() * 0.05;
        }
    }

    private double getBasePrice() {
        return _quantity * _itemPrice;
    }

    // 内联函数，简化
    private double getPrice_4 () {
        if (getDiscountLevel() == 2) {
            return getBasePrice() * 0.1;
        } else {
            return getBasePrice() * 0.05;
        }
    }

}
