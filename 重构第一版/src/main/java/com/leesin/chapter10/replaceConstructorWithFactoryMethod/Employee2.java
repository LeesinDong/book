package com.leesin.chapter10.replaceConstructorWithFactoryMethod;

/**
 * @description: 隐藏subclass   Employee是Employee2的铺垫，不用看Employee了
 * @author: dongxueyuan
 * @date: Created in 2020/11/26 9:51 上午
 */
public class Employee2 {
    static final int ENGINEER = 0;
    static final int SALESMAN = 1;
    static final int MANAGER = 2;
    private int _type;

    static Employee2 createOriginal(int type) {
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

    // TODO: 工厂方法替换直接的构造方法，通过反射实现
    static Employee2 create(String name) {
        try {
            // 或者传入class，直接class.newInstance()
            return (Employee2) Class.forName(name).newInstance();
        } catch (Exception e) {
            throw new IllegalArgumentException("Unable to instantiate" + name);
        }
    }

    // TODO: 修改原来的create方法中new xxx() 为create("xxx")，这里没有体现真正的威力
    static Employee2 create(int type) {
        switch (type) {
            case ENGINEER:
                return create("Engineer");
            case SALESMAN:
                return create("Salesman");
            case MANAGER:
                return create("Manager");
            default:
                throw new IllegalArgumentException("Incorrect type code value");
        }
    }

    public static void main(String[] args) {
        // TODO: 原来通过typecode创建，可以变成直接通过反射调用，而不需要switch了，绕过了switch
        //  缺点：写错字符串很危险
        Employee2.createOriginal(ENGINEER);
        Employee2.create("Engineer");
    }


    static class Engineer extends Employee2 {
    }

    static class Salesman extends Employee2 {
    }

    static class Manager extends Employee2 {
    }
}