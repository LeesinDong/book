package com.leesin.chapter11.extractSuperclass;

/**
 * @description:
 * @author: dongxueyuan
 * @date: Created in 2020/11/30 8:39 下午
 */
public abstract class Party {
    private String _name;

    /**
     * TODO: 1 子类都有name，把name的赋值提起来，到父类
     *
     * @description:
     * @name: Party
     * @param: name
     * @return:
     */
    protected Party(String name) {
        _name = name;
    }

    public String getName() {
        return _name;
    }

    /**
     * TODO: 2 两个子类都有getAnnualCost()方法，但是实现不一样，不能直接提取到父类
     * 提取成抽象方法，然后子类再调用父类的getAnnualCost方法，组合模式
     *
     * @return
     */
    abstract public int getAnnualCost();
}
