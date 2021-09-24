package com.leesin.chapter6.splitTemporaryVariable;

/**
 * @description:
 * @author: dongxueyuan
 * @date: Created in 2020/12/2 9:29 上午
 */
public class Example {

    Integer _primaryForce = 1;
    Integer _mass = 1;
    Integer _delay = 1;
    Integer _secondaryForce = 1;

    double getDistanceTravelledOriginal(int time) {
        double result;
        double acc = _primaryForce / _mass;
        //译注：第一次赋值处
        int primaryTime = Math.min(time, _delay);
        result = 0.5 * acc * primaryTime * primaryTime;
        int secondaryTime = time - _delay;
        if (secondaryTime > 0) {
            double primaryVel = acc * _delay;
            //以下是第二次赋值处
            acc = (_primaryForce + _secondaryForce) / _mass;
            result += primaryVel * secondaryTime + 0.5 * acc * secondaryTime * secondaryTime;
        }
        return result;
    }


    double getDistanceTravelled(int time) {
        double result;
        // TODO: acc第一处赋值 换个名字 final修饰
        double primaryAcc = _primaryForce / _mass;
        // 变成final编译通过，确保只被赋值一次，说明本次重构成功
        final int primaryTime = Math.min(time, _delay);
        result = 0.5 * primaryAcc * primaryTime * primaryTime;
        int secondaryTime = time - _delay;
        if (secondaryTime > 0) {
            double primaryVel = primaryAcc * _delay;
            // TODO: 第二次赋值 换个名字 final修饰
            final double secondaryAcc = (_primaryForce + _secondaryForce) / _mass;
            result += primaryVel * secondaryTime + 0.5 *
                    secondaryAcc * secondaryTime * secondaryTime;
        }
        return result;
    }
}
