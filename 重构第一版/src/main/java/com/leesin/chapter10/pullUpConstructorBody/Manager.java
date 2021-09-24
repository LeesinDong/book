package com.leesin.chapter10.pullUpConstructorBody;

/**
 * @description:
 * @author: dongxueyuan
 * @date: Created in 2020/11/30 1:46 下午
 */
public class Manager extends Employee {

    private int _grade;

    // 原来的构造函数
    // public ManagerOriginal(String name, String id, int grade) {
    //     _name = name;
    //     _id = id;
    //     _grade = grade;
    // }

    public Manager(String name, String id, int grade) {
        // todo 原来构造函数的 _name _id 赋值和父类完全一样的，直接移到父类汇总 然后supper，其他子类都可以用
        super(name, id);
        _grade = grade;
    }

    // 特殊情况 （只能有一个构造，先注释掉了）
    // public Manager (String name, String id, int grade) {
    //     super (name, id);
    //     _grade = grade;
    // 这段代码不能移到父类构造函数中，因为要用到_grade，
    // 只有子类的_grade = grade;执行了才能执行下面
    // if (isPriviliged()) {
    //     assignCar(); //every subclass does this
    // }
    // }

    // @Override
    // boolean isPriviliged() {
    //     return _grade > 4;
    // }

}
