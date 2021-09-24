package com.leesin.chapter10.removeSettingMethod;

import java.util.Vector;

/**
 * @description:
 * @author: dongxueyuan
 * @date: Created in 2020/11/25 1:23 下午
 */
public class Account {

    private String _id;

    Account(String id) {
        setId(id);
    }

    void setId(String arg) {
        _id = arg;
    }
}

// TODO: 代码改为：去掉setId方法，并将id改为final的
class Account1 {

    private final String _id;

    Account1(String id) {
        _id = id;
    }
}

// 其他问题
// 问题一：    // 如果里面的操作，比较复杂就换一个函数名字
class Account2 {

    private String _id;

    Account2(String id) {
        setId(id);
    }

    // set函数中做了 对引数做运算
    void setId(String arg) {
        _id = "ZZ" + arg;
    }
}

class Account3 {
//如下先注释了，代码报错
    // private final String _id;
    //
    // Account3(String id) {
    //     initializeId(id);
    // }
    //
    // void initializeId(String arg) {
    //     _id = "ZZ" + arg;
    // }
}

// 问题二：subclass 需要对superclass 的private 变量赋初值
//如下报错，先注释掉

// class InterestAccount extends Account {
//
//     private double _interestRate;
//
//     InterestAccount(String id, double rate) {
//         setId(id);
//         _interestRate = rate;
//     }
// }
//
// class InterestAccount1 {
//     private double _interestRate;
//
//     InterestAccount1(String id, double rate) {
//         // 最好的解决方法是使用superclass 构造函数：
//         super(id);
//         _interestRate = rate;
//     }
// }
//
// class InterestAccount2 {
//     private double _interestRate;
//
//     InterestAccount2(String id, double rate) {
//         // 如果不能那样做，那么使用一个命名良好的函数就是最好的选择：
//         initializeId(id);
//         _interestRate = rate;
//     }
// }

// 问题三：另一种需要考虑的情况就是对一个群集（collections）设值：
//我希望将设值函数替换为"add"操作加上"remove"操作
class Person {
    private Vector _courses;

    Vector getCourses() {
        return _courses;
    }

    void setCourses(Vector arg) {
        _courses = arg;
    }
}