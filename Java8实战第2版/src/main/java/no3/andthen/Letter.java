package no3.andthen;

import java.util.function.Function;

/**
 * @author Leesin Dong
 * @since 2021/10/16
 */
public class Letter {
    public static String addHeader(String text) {
        return "header" + text;
    }

    public static String transform(String text) {
        return text.replaceAll("ll", "lambda");
    }

    public static String addFooter(String text) {
        return text + "footer";
    }

    public static void main(String[] args) {
        Function<String, String> function =( (Function<String, String>) Letter::addHeader)
                .andThen(Letter::transform)
                .andThen(Letter::addFooter);
        System.out.println(function.apply("ll"));
    }
}
