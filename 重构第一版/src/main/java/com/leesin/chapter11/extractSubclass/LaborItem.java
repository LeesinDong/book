package com.leesin.chapter11.extractSubclass;

/**
 * @description:
 * @author: dongxueyuan
 * @date: Created in 2020/11/30 3:43 下午
 */
public class LaborItem extends JobItem {

    public LaborItem(int unitPrice, int quantity, boolean isLabor, Employee employee) {
        super(unitPrice, quantity, isLabor, employee);
    }

    /**
     * 新的构造函数
     * todo 1 将 employee放到子类的构造方法中
     **/
    public LaborItem(int quantity, Employee employee) {
        super(0, quantity, true, employee);
    }

    /**
     * todo 1 将getEmployee移到子类
     **/
    public Employee getEmployee() {
        return _employee;
    }


    /**
     * TODO: 2 多态移除 isLabor field
     **/
    @Override
    protected boolean isLabor() {
        return true;
    }

    /**
     * TODO: 3 多态取代条件式
     **/
    @Override
    public int getUnitPrice() {
        return _employee.getRate();
    }

}
