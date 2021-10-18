package no9.pattern;

import org.junit.Test;

import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * @author Leesin Dong
 * @since 2021/10/18
 */
public class Chain {

    @Test
    public void test() {
        Function<String, String> function =
                ((UnaryOperator<String>) (s) -> s + "1").andThen((s) -> s + "2");
        String apply = function.apply("1");
        System.out.println(apply);
    }

}
