package com.leesin.chapter10.introduceParameterObject;

import java.util.Date;
import java.util.Enumeration;
import java.util.Vector;

/**
 * @description:
 * @author: dongxueyuan
 * @date: Created in 2020/11/25 8:18 上午
 */
public class Account {
    double getFlowBetween (Date start, Date end) {
        double result = 0;
        Enumeration e = _entries.elements();
        while (e.hasMoreElements()) {
            Entry each = (Entry) e.nextElement();
            if (each.getDate().equals(start) ||
                    each.getDate().equals(end) ||
                    (each.getDate().after(start) && each.getDate().before(end)))
            {
                result += each.getValue();
            }
        }
        return result;
    }
    private Vector _entries = new Vector();

    // client code...
    // double flow = anAccount.getFlowBetween(startDate, endDate);
    Date startDate;
    Date endDate;
    double flow = new Account().getFlowBetween(startDate, endDate);




    // TODO: 1 把start end封装到DateRange对象中


    double getFlowBetween (Date start, Date end, DateRange range) {
        double result = 0;
        Enumeration e = _entries.elements();
        while (e.hasMoreElements()) {
            Entry each = (Entry) e.nextElement();
            if (each.getDate().equals(start) ||
                    each.getDate().equals(end) ||
                    (each.getDate().after(start) && each.getDate().before(end)))
            {
                result += each.getValue();
            }
        }
        return result;
    }
    double flow1 = new Account().getFlowBetween(startDate, endDate, null);


    // TODO: 2 去掉原来的start、end参数
    double getFlowBetween (Date end, DateRange range) {
        double result = 0;
        Enumeration e = _entries.elements();
        while (e.hasMoreElements()) {
            Entry each = (Entry) e.nextElement();
            if (each.getDate().equals(range.getStart()) ||
                    each.getDate().equals(end) ||
                    (each.getDate().after(range.getStart()) && each.getDate().before(end)))
            {
                result += each.getValue();
            }
        }
        return result;
    }
    double flow2 = new Account().getFlowBetween(endDate, new DateRange (startDate, null));

    double getFlowBetween (DateRange range) {
        double result = 0;
        Enumeration e = _entries.elements();
        while (e.hasMoreElements()) {
            Entry each = (Entry) e.nextElement();
            if (each.getDate().equals(range.getStart()) ||
                    each.getDate().equals(range.getEnd()) ||
                    (each.getDate().after(range.getStart()) && each.getDate().before(range.getEnd())))
            {
                result += each.getValue();
            }
        }
        return result;
    }
    double flow3 = new Account().getFlowBetween(new DateRange (startDate, endDate));

    // TODO: 有助于进一步发现能够提取的点，例如includes
    double getFlowBetween_5 (DateRange range) {
        double result = 0;
        Enumeration e = _entries.elements();
        while (e.hasMoreElements()) {
            Entry each = (Entry) e.nextElement();
            if (range.includes(each.getDate())) {
                result += each.getValue();
            }
        }
        return result;
    }

}
