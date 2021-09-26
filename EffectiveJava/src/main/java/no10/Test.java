package no10;

import java.util.Objects;

/**
 * @author Leesin Dong
 * @since Created in 2021/9/25 11:18 上午
 */
public class Test {

    private int a;

    private int b;

    static class A {

    }

    static class B extends A {

    }

    public static void main(String[] args) {
        B b = new B();
        A a = new A();
        System.out.println(a.getClass() == b.getClass());
        System.out.println(b instanceof A);
        System.out.println(null instanceof A);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Test test = (Test) o;
        return a == test.a && b == test.b;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }
}
