package no31;

import no22.T;
import no29.Stack;

import java.util.Iterator;
import java.util.List;

/**
 * @author Leesin Dong
 * @since Created in 2021/9/27 8:52 下午
 */
public class Test {
    public static void main(String[] args) {
        Stack<Number> stack = new Stack<>();
        stack.push(Integer.valueOf(1));

        Iterable<Integer> i = new Iterable<Integer>() {
            @Override
            public Iterator<Integer> iterator() {
                return null;
            }
        };
        // stack.pushAll(i);
    }

    public static <E extends Comparable<? super E >> E max(List<? extends E> list) {
        return null;
    }

    public static <E> void swap(List<E> list, int i, int j) {
        list.set(i, list.set(j, list.get(i)));
    }

    public static <E> void swap1(List<?> list, int i, int j) {
        helper(list, i, j);
    }

    public static <E> void helper(List<E> list, int i, int j) {
        list.set(i, list.set(j, list.get(i)));
    }
}
