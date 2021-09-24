package com.leesin.chapter6.replaceMethodWithMethodObject;

/**
 * @description:
 * @author: dongxueyuan
 * @date: Created in 2020/12/2 9:08 上午
 */
public class Account {

    public int delta() {
        return 0;
    }

    int gammaOriginal(int inputVal, int quantity, int yearToDate) {
        int importantValue1 = (inputVal * quantity) + delta();
        int importantValue2 = (inputVal * yearToDate) + 100;
        if ((yearToDate - importantValue1) > 100) {
            importantValue2 -= 20;
        }
        int importantValue3 = importantValue2 * 7;
        // and so on.
        return importantValue3 - 2 * importantValue1;
    }


    /**
     * TODO: 6 原来的函数变成委托
     **/
    int gamma(int inputVal, int quantity, int yearToDate) {
        return new Gamma(this, inputVal, quantity, yearToDate).compute();
    }
}
