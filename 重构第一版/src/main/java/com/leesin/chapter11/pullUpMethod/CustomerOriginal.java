package com.leesin.chapter11.pullUpMethod;

import java.util.Date;

/**
 * @description:
 * @author: dongxueyuan
 * @date: Created in 2020/11/30 1:30 下午
 */
public class CustomerOriginal {

    Date lastBillDate = new Date();

    class RegularCustomer extends CustomerOriginal {

        void createBill(Date date) {
            double chargeAmount = charge(lastBillDate, date);
        }

        double charge(Date lastBillDate, Date date) {
            return date.getTime();
        }
    }

    class PreferredCustomer extends CustomerOriginal {
        void createBill(Date date) {
            double chargeAmount = charge(lastBillDate, date);
        }

        double charge(Date lastBillDate, Date endDate) {
            return lastBillDate.getTime();
        }
    }

}


abstract class Customer {

    Date lastBillDate = new Date();

    /**
     * 两个子类的createBill方法完全一样，提取到父类
     **/
    void createBill(Date date) {
        double chargeAmount = charge(lastBillDate, date);
    }

    /**
     * 两个子类的charge方法不一样，声明抽象方法
     **/
    abstract double charge(Date lastBillDate, Date date);

    class RegularCustomer extends CustomerOriginal {


        double charge(Date lastBillDate, Date date) {
            return date.getTime();
        }
    }

    class PreferredCustomer extends CustomerOriginal {


        double charge(Date lastBillDate, Date endDate) {
            return lastBillDate.getTime();
        }
    }

}
