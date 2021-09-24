package com.leesin.chapter11.extractSuperclass;

import java.util.Enumeration;

/**
 * @description:
 * @author: dongxueyuan
 * @date: Created in 2020/11/30 8:39 下午
 */
public class Department extends Party {

    protected Department(String name) {
        super(name);
    }

    //原来的
    // @Override
    // public int getAnnualCost(){
    //     Enumeration e = getStaff();
    //     int result = 0;
    //     while (e.hasMoreElements()) {
    //         Employee each = (Employee) e.nextElement();
    //         result += each.getAnnualCost();
    //     }
    //     return result;
    // }

    /**
     * @description:
     * @name: getAnnualCost
     * @param:
     * @return: int
     */
    @Override
    public int getAnnualCost() {
        Enumeration e = getStaff();
        int result = 0;
        while (e.hasMoreElements()) {
            // TODO: 3 Employee.getAnnualCost() 变成了 Party.getAnnualCost()
            //  调用父类的
            Party each = (Party) e.nextElement();
            result += each.getAnnualCost();
        }
        return result;
    }

    private Enumeration getStaff() {
        return getStaff();
    }
}
