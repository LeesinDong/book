package com.leesin.chapter11.extractInterface;

/**
 * @description:
 * @author: dongxueyuan
 * @date: Created in 2020/11/30 9:48 下午
 */
public class Employee implements Billable {

    public int getRate() {
        return 0;
    }

    public boolean hasSpecialSkill() {
        return false;
    }

}
