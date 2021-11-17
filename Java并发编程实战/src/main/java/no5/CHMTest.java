package no5;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author Leesin Dong
 * @since 2021/11/16
 */
public class CHMTest {
    // 复合委托
    private final ConcurrentHashMap<Integer, Future> map = new ConcurrentHashMap<>();

    private void put(int key, int value) throws ExecutionException, InterruptedException {
        Future<Integer> future = map.get(key);
        if (map.get(key) != null) {
            Future<Integer> futureTask = new FutureTask<>(() -> 2);
            Future integer = map.putIfAbsent(key, futureTask);
            if (integer == null) {
                future = integer;
                ((FutureTask<Integer>) futureTask).run();
            }
        }
        future.get();
    }
}
