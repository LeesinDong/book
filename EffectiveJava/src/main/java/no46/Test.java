package no46;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Leesin Dong
 * @since Created in 2021/9/29 11:15 下午
 */
public class Test {
    private static class Apple{
        private int size;
        private int color;

        public int getSize() {
            return size;
        }

        public int getColor() {
            return color;
        }

        public Apple(int size, int color) {
            this.size = size;
            this.color = color;
        }

        @Override
        public String toString() {
            return "Apple{" +
                    "size=" + size +
                    ", color=" + color +
                    '}';
        }
    }

    public static void main(String[] args) {
        Map<Integer, Apple> collect = Stream.of(new Apple(1, 5), new Apple(1, 2))
                .collect(Collectors.toMap(Apple::getSize, a -> a, (oldVal, newVal) -> newVal));
        System.out.println(collect);
    }
}
