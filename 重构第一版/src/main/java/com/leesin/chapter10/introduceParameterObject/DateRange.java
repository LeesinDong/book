package com.leesin.chapter10.introduceParameterObject;

import java.util.Date;

/**
 * @description:
 * @author: dongxueyuan
 * @date: Created in 2020/11/25 8:18 上午
 */
public class DateRange {
    DateRange (Date start, Date end) {
        _start = start;
        _end = end;
    }
    Date getStart() {
        return _start;
    }
    Date getEnd() {
        return _end;
    }
    private final Date _start;
    private final Date _end;

    boolean includes (Date arg) {
        return (arg.equals(_start) ||
                arg.equals(_end) ||
                (arg.after(_start) && arg.before(_end)));
    }
}
