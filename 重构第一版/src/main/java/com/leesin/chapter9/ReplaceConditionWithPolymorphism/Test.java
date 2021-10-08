package com.leesin.chapter9.ReplaceConditionWithPolymorphism;

/**
 * @author Leesin Dong
 * @since Created in 2021/10/8 8:12 上午
 */
public class Test {
    private static class EmployeeType {
        static int code = 1;
        private static final int ENGINEER = 1;
        private static final int SALESMAN = 2;
        private static final int MANAGER = 3;

        static int payAmount() {
            switch(getTypeCode()) {
                case ENGINEER:
                    return 1;
                case SALESMAN:
                    return 2;
                case MANAGER:
                    return 3;
                default:
                    return 4;
            }
        }

        public static int getTypeCode() {
            return code;
        }
    }

    // 以下为多态的例子
    private static abstract class EmployeeTypePolymorphism {
        abstract int payAmount();
    }

    private static class Enginer extends EmployeeTypePolymorphism{
        @Override
        int payAmount() {
            return 1;
        }
    }

    private static class Salesman extends  EmployeeTypePolymorphism {
        @Override
        int payAmount() {
            return 2;
        }
    }

    private static class Manager extends EmployeeTypePolymorphism {
        @Override
        int payAmount() {
            return 3;
        }
    }

    public static void main(String[] args) {
        System.out.println(EmployeeType.payAmount());;
        EmployeeTypePolymorphism employeeTypePolymorphism = new Manager();
        System.out.println(employeeTypePolymorphism.payAmount());;
    }
}
