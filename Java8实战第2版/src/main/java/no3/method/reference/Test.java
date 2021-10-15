package no3.method.reference;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * @author Leesin Dong
 * @since 2021/10/15
 */
public class Test {
    static Map<String, Function<Integer, Fruit>> fruitFactory = new HashMap<>();

    static {
        fruitFactory.put("apple", Fruit::new);
        fruitFactory.put("orange", Fruit::new);
    }

    public static void main(String[] args) {
        Fruit apple = fruitFactory.get("apple").apply(1);
        Fruit orange = fruitFactory.get("orange").apply(2);

        System.out.println(apple);
        System.out.println(orange);
    }
}
