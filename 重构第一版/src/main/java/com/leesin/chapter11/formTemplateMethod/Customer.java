package com.leesin.chapter11.formTemplateMethod;

import java.util.Enumeration;

/**
 * @description:
 * @author: dongxueyuan
 * @date: Created in 2020/12/1 9:20 上午
 */
public abstract class Customer {
    public String statement() {
        return new TextStatement().value(this);
    }

    public String htmlStatement() {
        return new HtmlStatement().value(this);
    }

    protected abstract Enumeration getRentals();

    public abstract String getName();

    public abstract char[] getTotalCharge();

    public abstract char[] getTotalFrequentRenterPoints();


    /**
     * TODO: 子类把之间的区别提取出来成方法，最后变成一样的函数体
     * 将函数体上移，子不同的方法上移成抽象方法
     **/
    public String value(Customer aCustomer) {
        Enumeration rentals = aCustomer.getRentals();
        String result = headerString(aCustomer);
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += eachRentalString(each);
        }
        result += footerString(aCustomer);
        return result;
    }

    abstract String headerString(Customer aCustomer);

    abstract String eachRentalString(Rental aRental);

    abstract String footerString(Customer aCustomer);

}
