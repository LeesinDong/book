package com.leesin.chapter11.extractSubclass;

/**
 * @description:
 * @author: dongxueyuan
 * @date: Created in 2020/11/30 4:28 下午
 */
public class Example {

    public static void main(String[] args) {
        // JobItem j1 = new JobItem (0, 5, true, kent);
        // 对JobItem构造函数的调用丢该为：
        JobItem.Employee kent = null;
        JobItem j1 = new LaborItem(0, 5, true, kent);
        // 使用新的构造函数
        JobItem j2 = new JobItem(10, 15);

    }

}
