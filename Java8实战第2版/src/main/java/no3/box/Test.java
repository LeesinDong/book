package no3.box;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author Leesin Dong
 * @since 2021/10/15
 */
public class Test {
    static int i = 0;
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2);
        Consumer<Integer> fun = Integer::valueOf;
        // Consumer<Integer> fun = ();
        // Consumer<Integer> fun1 = (i) -> {return test();};
        // 因为允许不赋值，这里泛指   A = b()  中的b方法，本质 当做语句看的 {b()} 是匹配的，可以简化为这个
        test();

        Object o = (Runnable) () -> i = 2;
        // execute(() -> {});

    }

    public static void execute(Runnable runnable) {
        runnable.run();
    }

    public static <T> void  execute(Action<T> action) {
        action.act();
    }

    @FunctionalInterface
    interface Action<T> {
        void act();
    }

    public static boolean test(){
        return false;
    }
}
