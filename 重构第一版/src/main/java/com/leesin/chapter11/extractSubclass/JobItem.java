package com.leesin.chapter11.extractSubclass;

/**
 * @description:
 * @author: dongxueyuan
 * @date: Created in 2020/11/30 3:42 下午
 */
public class JobItem {
    protected Employee _employee;
    private int _unitPrice;
    private int _quantity;

    // public int getTotalPrice() {
    //     return getUnitPrice() * _quantity;
    // }

    // public int getUnitPrice() {
    //     return (_isLabor) ?
    //             _employee.getRate() :
    //             _unitPrice;
    // }
    // private Employee _employee;
    private boolean _isLabor;

    // public Employee getEmployee() {
    //     return _employee;
    // }

    protected JobItem(int unitPrice, int quantity, boolean isLabor, Employee employee) {
        _unitPrice = unitPrice;
        _quantity = quantity;
        _isLabor = isLabor;
        _employee = employee;
    }

    // 新的构造函数
    public JobItem(int unitPrice, int quantity) {
        this(unitPrice, quantity, false, null);
    }

    public int getQuantity() {
        return _quantity;
    }

    /**
     * TODO: 2 多态移除 isLabor field
     *
     * @description: 多态移除isLabor函数
     * @name: isLabor
     * @param:
     * @return: boolean
     */
    protected boolean isLabor() {
        return false;
    }

    /**
     * TODO: 3 多态取代条件式
     **/
    public int getUnitPrice() {
        return _unitPrice;
    }

    class Employee {
        private int _rate;

        public Employee(int rate) {
            _rate = rate;
        }

        public int getRate() {
            return _rate;
        }
    }
}
