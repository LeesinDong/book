package no49;

import java.util.Objects;

/**
 * @author Leesin Dong
 * @since Created in 2021/9/30 2:16 下午
 */
public class Test {

    /**
     * @throws IllegalArgumentException null
     */
    public void testThrowDoc(Integer integer) {
        Integer integer1 = Objects.requireNonNull(integer);

    }
}
