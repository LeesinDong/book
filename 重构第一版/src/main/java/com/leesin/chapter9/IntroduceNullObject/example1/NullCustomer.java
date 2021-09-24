package com.leesin.chapter9.IntroduceNullObject.example1;

/**
 * @description:
 * @author: dongxueyuan
 * @date: Created in 2020/11/23 8:47 上午
 */
public class NullCustomer extends Customer {
    @Override
    public boolean isNull() {
        return true;
    }

    @Override
    public String getName(){
        return "occupant";
    }

    @Override
    public BillingPlan getPlan() {
        return new BillingPlan();
    }

    @Override
    public PaymentHistory getHistory() {
        return new NullPaymentHistory();
    }
}
