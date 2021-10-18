package no9.pattern;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.junit.Test;

import java.util.Objects;
import java.util.function.Consumer;

/**
 * @author Leesin Dong
 * @since 2021/10/18
 */
public class ConditionalDelayExecute {
    @Test
    public  void test() {
        Inner inner = Inner.builder().status(1).build();
        if (Objects.equals(inner.status, 1) ) {
            inner.sout("haha");
        }
    }


    @Builder
    @Data
    @AllArgsConstructor
    private static class Inner {
        int status = 1;

        private void sout(String s) {
            System.out.println("---");
            System.out.println(s);
            System.out.println("00000");;
        }

    }

    @Test
    public  void test1() {
        Inner1 inner1 = Inner1.builder().status(1).build();
        inner1.tt(inner1, i -> inner1.sout("haha"));
    }


    @Builder
    @Data
    @AllArgsConstructor
    private static class Inner1 {
        int status = 1;

        private void tt(Inner1 inner, Consumer<String> consumer) {
            if (Objects.equals(inner.status, 1) ) {
                consumer.accept("");
            }
        }

        private void sout(String s) {
            System.out.println("---");
            System.out.println(s);
            System.out.println("00000");;
        }
    }
}
