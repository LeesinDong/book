package com.leesin.chapter8.selfEncapsulateField;

/**
 * @description:
 * @author: dongxueyuan
 * @date: Created in 2020/12/2 1:06 下午
 */
public class CappedRange extends IntRange {

    private int _cap;

    CappedRange(int low, int high, int cap) {
        super(low, high);
        _cap = cap;
    }

    int getCap() {
        return _cap;
    }

    /**
     * 现在，我可以在CappedRange class中覆写getHigh()，
     * 从而加入对cap的考虑，而不必修改IntRange class的任何行为。
     * <p>
     * TODO: 子类覆写父类get函数，从而在原来基础上包装field，就是开闭原则
     **/
    @Override
    int getHigh() {
        return Math.min(super.getHigh(), getCap());
    }

}

