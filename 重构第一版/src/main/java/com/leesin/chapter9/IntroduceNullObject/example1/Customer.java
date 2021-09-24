package com.leesin.chapter9.IntroduceNullObject.example1;

/**
 * @description:
 * @author: dongxueyuan
 * @date: Created in 2020/11/23 8:45 上午
 */
public class Customer implements Nullable{
    public String getName() {
        return "";
    }

    public BillingPlan getPlan() {
        return new BillingPlan();
    }

    public PaymentHistory getHistory() {
        return new PaymentHistory();
    }

    public boolean isNull() {
        return false;
    }

    public static Customer newNull() {
        return new NullCustomer();
    }

    protected Customer() {} //needed by the NullCustomer
}
