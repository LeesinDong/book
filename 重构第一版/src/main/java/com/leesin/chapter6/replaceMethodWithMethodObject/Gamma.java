package com.leesin.chapter6.replaceMethodWithMethodObject;

/**
 * @description:
 * @author: dongxueyuan
 * @date: Created in 2020/12/2 9:08 上午
 */
public class Gamma {
    /**
     * TODO: 1我首先需要声明一个新class
     * 2 在此新class中我应该提供一个final值域用以保存原先对象（源对象）；
     **/
    private final Account _account;
    /**
     * TODO: 3 对于函数的每一个参数和每一个临时变量，也以一个个值域逐一保存
     **/
    private int inputVal;
    private int quantity;
    private int yearToDate;
    private int importantValue1;
    private int importantValue2;
    private int importantValue3;

    /**
     * TODO: 4 加入一个构造函数
     **/
    Gamma(Account source, int inputValArg, int quantityArg, int yearToDateArg) {
        _account = source;
        inputVal = inputValArg;
        quantity = quantityArg;
        yearToDate = yearToDateArg;
    }

    /**
     * TODO: 5 把原先的函数搬到compute
     **/
    /**
     * TODO: 7 这样能够对compute进行Extract，而不需要担心 参数过多的问题
     **/
    int compute() {
        // delta() 改成 _account.delta()
        importantValue1 = (inputVal * quantity) + _account.delta();
        importantValue2 = (inputVal * yearToDate) + 100;
        if ((yearToDate - importantValue1) > 100) {
            importantValue2 -= 20;
        }
        int importantValue3 = importantValue2 * 7;
        // and so on.
        return importantValue3 - 2 * importantValue1;
    }
}
