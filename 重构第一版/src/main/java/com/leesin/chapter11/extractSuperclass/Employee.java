package com.leesin.chapter11.extractSuperclass;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @description:
 * @author: dongxueyuan
 * @date: Created in 2020/11/30 8:38 下午
 */
public class Employee extends Party {
    private String _name;
    private int _annualCost;
    private String _id;

    public Employee(String name, String id, int annualCost) {
        super(name);
        _id = id;
        _annualCost = annualCost;
    }

    @Override
    public int getAnnualCost() {
        return _annualCost;
    }

    public String getId() {
        return _id;
    }

    @Override
    public String getName() {
        return _name;
    }

    public class Department {
        private String _name;
        private Vector _staff = new Vector();

        public Department(String name) {
            _name = name;
        }

        public int getTotalAnnualCost() {
            Enumeration e = getStaff();
            int result = 0;
            while (e.hasMoreElements()) {
                Employee each = (Employee) e.nextElement();
                result += each.getAnnualCost();
            }
            return result;
        }

        public int getHeadCount() {
            return _staff.size();
        }

        public Enumeration getStaff() {
            return _staff.elements();
        }

        public void addStaff(Employee arg) {
            _staff.addElement(arg);
        }

        public String getName() {
            return _name;
        }
    }
}
