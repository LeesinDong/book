package com.leesin.chapter11.replaceDelegationWithInheritance;

/**
 * @description:
 * @author: dongxueyuan
 * @date: Created in 2020/12/1 9:46 上午
 */
class Employee extends Person {
    Person _person = new Person();

    public String getNameOriginal() {
        return _person.getName();
    }

    public void setNameOriginal(String arg) {
        _person.setName(arg);
    }

    public String toStringOriginal() {
        return "Emp: " + _person.getLastName();
    }

    @Override
    public String getName() {
        // TODO: 变成直接调用父类的
        return getName();
    }

    @Override
    public void setName(String arg) {
        // TODO: 变成直接调用父类的
        setName(arg);
    }

    @Override
    public String toString() {
        // TODO: 变成直接调用父类的
        return "Emp: " + getLastName();
    }
}
