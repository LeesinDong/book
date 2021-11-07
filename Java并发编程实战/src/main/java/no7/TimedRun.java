package no7;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * @author Leesin Dong
 * @since 2021/11/7
 */
public class TimedRun {
    ExecutorService executorService = Executors.newFixedThreadPool(10);


    @Test
    public void test() {

        Future<Object> submit = executorService.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                // Thread.currentThread().interrupt();
                // throw new InterruptedException();
                throw new RuntimeException();
                // return "haha";
            }
        });
        try {
            submit.get(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println("cancel");
            submit.cancel(true);
        } catch (ExecutionException e) {
            // e.printStackTrace();
            throw new RuntimeException();
        } catch (TimeoutException e) {
        } finally {
            System.out.println("1243");
        }
            // finally {
        //     System.out.println("cancel");
        //     submit.cancel(true);
        // }
    }
}
