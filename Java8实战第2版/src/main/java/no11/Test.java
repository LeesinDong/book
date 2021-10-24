package no11;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Optional;

/**
 * @author Leesin Dong
 * @since 2021/10/18
 */
public class Test {
    public static void main(String[] args) {
        Apple build = new Apple(null);
        // Optional<Object> o = Optional.ofNullable(build)
        //         .flatMap(null);

        Optional<Object> o1 = Optional.ofNullable(null);
        System.out.println(o1);
    }

    @Data
    @AllArgsConstructor
    private static class Apple {
        private String color;
    }

    private static Optional<Object> get() {
        try {
            return Optional.ofNullable(1);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
