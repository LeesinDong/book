package no2;

import java.awt.*;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Leesin Dong
 * @since 2021/10/15
 */
public class Test {
    public static void main(String[] args) {
        Arrays.asList(1, 2, 3).sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });

        // ExecutorService executorService = Executors.newFixedThreadPool();
        // executorService.submit(new Callable<Object>() {
        //     @Override
        //     public Object call() throws Exception {
        //         return null;
        //     }
        // });

        Button button = new Button();

    }
}
