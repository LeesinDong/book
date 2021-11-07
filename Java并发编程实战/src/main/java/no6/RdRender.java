package no6;

import java.util.concurrent.*;

/**
 * @author Leesin Dong
 * @since 2021/11/7
 */
public class RdRender {
    static ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        Future<Object> submit = executorService.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                return null;
            }
        });

        try {
            Object o = submit.get(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            Object o = null;
        } catch (TimeoutException e) {
            Object o = null;
            submit.cancel(true);
        }
    }
}
