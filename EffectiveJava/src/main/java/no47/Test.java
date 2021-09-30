package no47;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @author Leesin Dong
 * @since Created in 2021/9/30 10:49 上午
 */
public class Test {
    public static void main(String[] args) {
        Stream<Integer> integerStream = Stream.of(1, 2);
        for (Integer i : (Iterable<? extends Integer>) Stream.of(1, 2)::iterator) {

        }
    }

    public <E> Iterable<E> iterableOf(Stream<E> stream) {
        return stream::iterator;
    }


    public <E> Stream<E> streamOf(Iterable<E> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false);
    }
}
