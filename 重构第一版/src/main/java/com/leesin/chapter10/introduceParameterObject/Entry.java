package com.leesin.chapter10.introduceParameterObject;

import java.util.Date;

/**
 * @description:
 * @author: dongxueyuan
 * @date: Created in 2020/11/25 8:16 上午
 */
public class Entry {
    Entry (double value, Date chargeDate) {
        _value = value;
        _chargeDate = chargeDate;
    }
    Date getDate(){
        return _chargeDate;
    }
    double getValue(){
        return _value;
    }
    private Date _chargeDate;
    private double _value;
}
