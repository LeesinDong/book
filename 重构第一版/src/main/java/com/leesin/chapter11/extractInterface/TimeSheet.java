package com.leesin.chapter11.extractInterface;

/**
 * @description:
 * @author: dongxueyuan
 * @date: Created in 2020/11/30 9:46 下午
 */
public class TimeSheet {
    public static void main(String[] args) {

    }

    double chargeOriginal(Employee emp, int days) {
        int base = emp.getRate() * days;
        if (emp.hasSpecialSkill()) {
            return base * 1.05;
        } else {
            return base;
        }
    }

    /**
     * TODO: 2 这里用接口强调只是用Employee的这部分行为
     **/
    double charge(Billable emp, int days) {
        int base = emp.getRate() * days;
        if (emp.hasSpecialSkill()) {
            return base * 1.05;
        } else {
            return base;
        }
    }
}
