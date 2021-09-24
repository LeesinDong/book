package com.leesin.chapter10.replaceParameterwithExplicitMethods;

/**
 * @description:
 * @author: dongxueyuan
 * @date: Created in 2020/11/24 1:10 下午
 */
public class Employee {
    static final int ENGINEER = 0;
    static final int SALESMAN = 1;
    static final int MANAGER = 2;

    static Employee create_original(int type) {
        switch (type) {
            case ENGINEER:
                return new Engineer();
            case SALESMAN:
                return new Salesman();
            case MANAGER:
                return new Manager();
            default:
                throw new IllegalArgumentException("Incorrect type code value");
        }
    }

    // TODO：①把switch变成直接创建的子函数
    static Employee createEngineer() {
        return new Engineer();
    }

    static Employee createSalesman() {
        return new Salesman();
    }

    static Employee createManager() {
        return new Manager();
    }

    // TODO（略）：把switch变成
    static Employee create(int type) {
        switch (type) {
            case ENGINEER:
                return Employee.createEngineer();
            case SALESMAN:
                return Employee.createSalesman();
            case MANAGER:
                return Employee.createManager();
            default:
                throw new IllegalArgumentException("Incorrect type code value");
        }
    }

    // TODO：②修改调用处switch调用为直接通过子函数调用-
    //  （跟多态的区别：这里没有调用抽象方法，而是直接调用的子方法，
    //  为了更明显的表达拆分方法，多态是升级后的这个，记住多态就好了）
    Employee kent = Employee.create(ENGINEER);
    Employee kent1 = Employee.createEngineer();
}
