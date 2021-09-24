package com.leesin.chapter11.extractInterface;

/**
 * @description:
 * @author: dongxueyuan
 * @date: Created in 2020/11/30 9:46 下午
 */
public interface Billable {

    /**
     * TODO: 1 Employee 还有很多其他方面的功能，但本应用程序只需这两项功能。我可以针对这两项功能定义一个接口，从而强调「我 只需要这部分功能」的事实
     **/
    public int getRate();

    public boolean hasSpecialSkill();
}
