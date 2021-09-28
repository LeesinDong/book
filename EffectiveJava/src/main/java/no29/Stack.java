package no29;

import com.sun.xml.internal.fastinfoset.algorithm.BooleanEncodingAlgorithm;

import java.util.Arrays;

/**
 * @author Leesin Dong
 * @since Created in 2021/9/27 4:59 下午
 */
public class Stack<E> {
    private E[] elements;
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 16;

    public void pushAll(Iterable<E> iterable) {
    // public void pushAll(Iterable<E> iterable) {
        for (E e : iterable) {
            push(e);
        }
    }

    @SuppressWarnings("unchecked")
    public Stack(){
        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public void push(E e) {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
        elements[size++] = e;
    }

    public E pop() {
        if (size == 0) {
            throw new RuntimeException();
        }

        E result = elements[--size];
        elements[size] = null;
        return result;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    static class Test {
        public static void main(String[] args) {
            Stack stack  = new Stack();
            String[] arr = new String[]{"1", "2"};
            for (int i = 0; i < arr.length; i++) {
                stack.push(arr[i]);
            }
            while (!stack.isEmpty()) {
                System.out.println(stack.pop().toString());
            }
        }
    }

    static class Original {
        private Object[] elements;
        private int size = 0;
        private static final int DEFAULT_CAPACITY = 16;

        public Original(){
            elements = (Object[]) new Object[DEFAULT_CAPACITY];
        }

        public void push(Object e) {
            if (elements.length == size) {
                elements = Arrays.copyOf(elements, 2 * size + 1);
            }
            elements[size++] = e;
        }

        public Object pop() {
            if (size == 0) {
                throw new RuntimeException();
            }

            Object result = elements[--size];
            elements[size] = null;
            return result;
        }
    }
}
