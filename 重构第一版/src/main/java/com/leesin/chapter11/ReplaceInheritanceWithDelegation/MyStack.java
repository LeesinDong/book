package com.leesin.chapter11.ReplaceInheritanceWithDelegation;

import java.util.Vector;

/**
 * @description:
 * @author: dongxueyuan
 * @date: Created in 2020/12/1 9:36 上午
 */
class MyStack extends Vector {
    /**
     * 将父类声明为本field
     **/
    private Vector _vector = new Vector();

    /**
     * 原来有四个函数：push()、pop()、和继承来的：size() 和 isEmpty()
     **/
    public void pushOriginal(Object element) {
        insertElementAt(element, 0);
    }

    public Object popOriginal() {
        Object result = firstElement();
        removeElementAt(0);
        return result;
    }

    public void push(Object element) {
        // TODO: 变成调用委托类的方法
        _vector.insertElementAt(element, 0);
    }

    public Object pop() {
        Object result = _vector.firstElement();
        // TODO: 变成调用委托类的方法
        _vector.removeElementAt(0);
        return result;
    }

}