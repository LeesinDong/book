package no13;

import lombok.Builder;

/**
 * @author Leesin Dong
 * @since Created in 2021/9/25 4:06 下午
 */
public class Test implements Cloneable{
    public static void main(String[] args) throws CloneNotSupportedException {
        Test test = new Test();
        // test.clone();
        Son son = Son.newInstance();
        System.out.println(son.toString());
    }

    // @Override
    // public Test clone() {
    //     try {
    //         return (Test) super.clone();
    //     } catch (CloneNotSupportedException e) {
    //         e.printStackTrace();
    //     } finally {
    //
    //     }
    //     return  null;
    // }

    @Override
    protected final Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    @Override
    public String toString() {
        return "aaa";
    }

    @Builder
    private static class Son extends Test{

        public static Son son = new Son();

        public Son() {

        }

        public static Son newInstance() {
            return son;
        }

        // 执行离他最近的父类的方法
        @Override
        public String toString() {
            return super.toString();
        }
    }
}
