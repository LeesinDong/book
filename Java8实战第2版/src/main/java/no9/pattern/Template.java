package no9.pattern;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.junit.Test;

import java.util.function.Consumer;

/**
 * @author Leesin Dong
 * @since 2021/10/18
 */
public class Template {

    @Test
    public void test() {
        Big.builder().build().process("1234", System.out::println);
    }

    @Builder
    @AllArgsConstructor
    @Data
    private static class Big {
        private void process(String s, Consumer<String> consumer) {
            System.out.println("header");
            consumer.accept(s);
            System.out.println("footer");
        }
    }
}
