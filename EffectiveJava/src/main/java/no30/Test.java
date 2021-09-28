package no30;

import no22.T;

import javax.xml.bind.Element;
import java.util.HashSet;
import java.util.Set;
import java.util.function.UnaryOperator;

/**
 * @author Leesin Dong
 * @since Created in 2021/9/27 7:21 下午
 */
public class Test {
    private static UnaryOperator<Integer> function = i -> i;

    public static <T> UnaryOperator<T> getFunction() {
        return (UnaryOperator<T>) function;
    }

    public static void main(String[] args) {
        UnaryOperator<String> function = getFunction();
        System.out.println(function.apply("2"));
        // Test test = new Test();
        // Son test1 = (Son) test;

        Son son = new Son();
        Test son1 = (Test)son;
    }

    public <E> Set<E> Union(Set<E> s1, Set<E> s2) {
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }

    public

    static class Son extends Test {

    }
}
